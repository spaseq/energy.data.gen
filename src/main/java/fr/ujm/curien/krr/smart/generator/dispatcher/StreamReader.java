package fr.ujm.curien.krr.smart.generator.dispatcher;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.semanticweb.yars.nx.parser.NxParser;


public final class StreamReader {
static List<Integer> fileReaderList= new ArrayList<Integer>(Arrays.asList(0,1,2));
	static BufferedReader[] readers = new BufferedReader[3];

	private static final String ENVIRONMENTAL_FILE = "/environmental1k.nt";
	private static final String GENERATION_FILE = "/generation1k.nt";
	private static final String POWER_FILE = "/power1k.nt";

	final static String[] currents = new String[3];

	final NxParser parser;
	final String fileLocation;
	static int finishedStreams = 0;

	static int nextToRead =0;
	static int x =0;
	public StreamReader(final String string, final NxParser parser) {
		fileLocation=string;
		this.parser = parser;
		// Open The streams
		openReaders();
	}

	/**
	 * Open the readers for the four files
	 */
	private void openReaders() {

		try {
			readers[0] = new BufferedReader(
					new InputStreamReader(new FileInputStream(new File(this.fileLocation + ENVIRONMENTAL_FILE))));
			readers[1] = new BufferedReader(
					new InputStreamReader(new FileInputStream(new File(this.fileLocation + GENERATION_FILE))));
			readers[2] = new BufferedReader(
					new InputStreamReader(new FileInputStream(new File(this.fileLocation + POWER_FILE))));
			

		} catch (final Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 *
	 * @return the next element to be sent
	 */
	private static String readRound123() {
		final String line = readLine(nextToRead);
		if (line != null) {
			switch (nextToRead) {
			case 0:
				currents[0] = line;
				break;
			case 1:
				currents[1] = line;
				break;
			case 2:
				currents[2] = line;
				break;
			default:
				break;
			}
			
		}
		x++;
		nextToRead++;
		nextToRead= nextToRead % 3;
		if (nextToRead % 1_000_000==0)
		System.out.println(x    +"   "+ finishedStreams);
		return currents[nextToRead];
	}

	private static String readRound() {
		final String line = readLine(nextToRead);
		if (line != null) {
			switch (nextToRead) {
			case 0:
				currents[0] = line;
				break;
			case 1:
				currents[1] = line;
				break;
			case 2:
				currents[2] = line;
				break;
			default:
				break;
			}
			Collections.shuffle(fileReaderList);
			nextToRead=fileReaderList.get(0);
			
		}
		else{
		fileReaderList.remove(0);
		if (fileReaderList.size()>0){
		Collections.shuffle(fileReaderList);
		nextToRead=fileReaderList.get(0);}
		}
	
		return currents[nextToRead];
	}
	
	
	static String readLine(final int i) {
		if (readers[i] != null) {
			String line = null;
			try {
				line = readers[i].readLine();
			} catch (final IOException e) {
				e.printStackTrace();
				System.exit(-1);
			}
			if (line == null) {
				readers[i] = null;
				finishedStreams++;
			}
			return line;
		} else {
			return null;
		}
	}
	
	public static  int  random123()
	{
		Collections.shuffle(fileReaderList);
		System.out.println(fileReaderList.get(0));
		//System.out.println(random[new Random().nextInt(random.length)]);
		return fileReaderList.get(0);
		
	}

	/**
	 * read from generated files
	 * @param args
	 */

	public static void main(String[] args) {

		StreamReader sr=new StreamReader("SmartGenerator/data", new NxParser());
		
		currents[0] = readLine(0);
		currents[1] = readLine(1);
		currents[2] = readLine(2);

		do {
		
			final String record = readRound();
			System.out.println(record);

		} while (finishedStreams != 3);
		
		}

}

