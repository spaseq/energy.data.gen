package fr.ujm.curien.krr.smart.generator.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import fr.ujm.curien.krr.smart.generator.beans.Generation;
import fr.ujm.curien.krr.smart.generator.beans.Power;
import fr.ujm.curien.krr.smart.generator.parser.Parser;

public class MainGenerator {

	public static void main(String[] args) throws IOException, URISyntaxException {

		System.out.println("enter the price range (p1 p2) of renewable energy and the range of price of the enrgy produced using fuel\n and the path for the source file: homeC-all");
		
		int p1 = Integer.parseInt(args[0]);
		int p2 = Integer.parseInt(args[1]);
		int p3 = Integer.parseInt(args[2]);
		int p4 = Integer.parseInt(args[3]);

		String  environmental_Folder= args[4];
		String  generation_Folder= args[5];
		String  power_Folder= args[6];
		
		Parser parser = new Parser();
		
		File environmentalFolder = new File(environmental_Folder);
		File[] listOfFiles = environmentalFolder.listFiles();
		File fileEnvironmental = new File("environmental.nt");

		if (!fileEnvironmental.exists()) {
			fileEnvironmental.createNewFile();
		}
		FileWriter fw = new FileWriter(fileEnvironmental.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		int x = 0;
		for (int i = 0; i <  listOfFiles.length - 1; i++) {
			File filePath = listOfFiles[i];
			if ( ! filePath.toString().contains("DS") && ! filePath.toString().contains("FORMAT") ){
		
			try {
				BufferedReader environmentalBR = new BufferedReader(
						new InputStreamReader(new FileInputStream(filePath.toString())));
				while (environmentalBR.ready()) {
					x++;
					String line1 = environmentalBR.readLine();
					bw.write(parser.parseEnvironmental(line1).toRDF());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		System.out.println("nb line " + x + " nb file " + listOfFiles.length);
		
		
		bw.close();

		System.out.println("Done for environmental");

	//	URI uri2 = classLoader.getResource(args[5]+"homeC-generation").toURI();

		File generatinFolder = new File(generation_Folder);
		listOfFiles = generatinFolder.listFiles();
		File fileGeneration = new File("generation.nt");
		// if file doesnt exists, then create it
		if (!fileGeneration.exists()) {
			fileGeneration.createNewFile();
		}
		FileWriter fw1 = new FileWriter(fileGeneration.getAbsoluteFile());
		BufferedWriter bw1 = new BufferedWriter(fw1);
		x = 0;
		for (int i = 0; i < listOfFiles.length - 1; i++) {
			File filePath = listOfFiles[i];
			if ( ! filePath.toString().contains("DS") && ! filePath.toString().contains("FORMAT") ){
			//System.out.println(filePath);
			
			try {
				BufferedReader generationBR = new BufferedReader(
						new InputStreamReader(new FileInputStream(filePath.toString())));
				while (generationBR.ready()) {
					x++;
					String line1 = generationBR.readLine();
					Generation generation = parser.parseGeneration(line1);
					generation.setPrice(p1, p2);
					bw1.write(generation.toRDF());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		}
		
		bw1.close();

		System.out.println("Done for geneartion");

		File powerFolder = new File(power_Folder);
		listOfFiles = powerFolder.listFiles();
		File filePower = new File("power.nt");
		
		if (!filePower.exists()) {
			filePower.createNewFile();
		}
		FileWriter fw3 = new FileWriter(filePower.getAbsoluteFile());
		BufferedWriter bw3 = new BufferedWriter(fw3);
		x = 0;
		for (int i = 0; i < listOfFiles.length - 1; i++) {
			File filePath = listOfFiles[i];
			if ( ! filePath.toString().contains("DS") && ! filePath.toString().contains("FORMAT") ){
				//System.out.println(filePath);
			try {
				BufferedReader powerBR = new BufferedReader(
						new InputStreamReader(new FileInputStream(filePath.toString())));
				while (powerBR.ready()) {
					String line1 = powerBR.readLine();
					Power power = parser.parsePower(line1);
					power.setPrice(p3, p4);
					bw3.write(power.toRDF());
					x++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}}
		System.out.println(x + " nb file " + listOfFiles.length);
		bw3.close();

		System.out.println("Done for power");
	}
}
