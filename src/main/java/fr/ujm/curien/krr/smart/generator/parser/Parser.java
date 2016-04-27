package fr.ujm.curien.krr.smart.generator.parser;

import fr.ujm.curien.krr.smart.generator.beans.Environmental;
import fr.ujm.curien.krr.smart.generator.beans.Generation;
import fr.ujm.curien.krr.smart.generator.beans.Power;

/**
 * Simple parser using:
 * <ul>
 * <li>{@link String#indexOf(String, int)} loops to split strings</li>
 * <li>No extra array instantiation for split</li>
 * <li>Intern Strings that should occur commonly (i.e. usernames)</li>
 * </ul>
 * {@link String#indexOf(String, int)} loops.
 * 
 * @author kammoun
 *
 */
public class Parser implements ParserI {
	/**
	 * Array to store temporary strings from parsing
	 */
	private static final String[] TMP_ARRAY = new String[13];

	public Environmental parseEnvironmental(String line) {
		int pos = 0, end;
		int cpt = 0;
		while ((end = line.indexOf(",", pos)) >= 0) {
			TMP_ARRAY[cpt++] = (line.substring(pos, end));
			pos = end + 1;
		}
		TMP_ARRAY[cpt] = line.substring(pos, line.length());
		return new Environmental(Long.parseLong(TMP_ARRAY[0]), Double.parseDouble(TMP_ARRAY[1]),
				Integer.parseInt(TMP_ARRAY[2]), Double.parseDouble(TMP_ARRAY[3]), Double.parseDouble(TMP_ARRAY[4]),
				Integer.parseInt(TMP_ARRAY[5]), Integer.parseInt(TMP_ARRAY[6]), Integer.parseInt(TMP_ARRAY[7]),
				Double.parseDouble(TMP_ARRAY[8]), Double.parseDouble(TMP_ARRAY[9]), Double.parseDouble(TMP_ARRAY[10]),
				Double.parseDouble(TMP_ARRAY[11]), Double.parseDouble(TMP_ARRAY[12]));
	}

	public Generation parseGeneration(String line) {
		int pos = 0, end;
		int cpt = 0;
		while ((end = line.indexOf(',', pos)) >= 0) {
			TMP_ARRAY[cpt++] = (line.substring(pos, end));
			pos = end + 1;
		}
		TMP_ARRAY[cpt] = line.substring(pos, line.length());
		return new Generation(Long.parseLong(TMP_ARRAY[0]), Double.parseDouble(TMP_ARRAY[1]),
				Double.parseDouble(TMP_ARRAY[2]), Double.parseDouble(TMP_ARRAY[3]), Double.parseDouble(TMP_ARRAY[4]),
				Double.parseDouble(TMP_ARRAY[5]), Double.parseDouble(TMP_ARRAY[6]));
	}

	public Power parsePower(String line) {
		int pos = 0, end;
		int cpt = 0;
		while ((end = line.indexOf(',', pos)) >= 0) {
			TMP_ARRAY[cpt++] = (line.substring(pos, end));
			pos = end + 1;
		}
		TMP_ARRAY[cpt] = line.substring(pos, line.length());
		return new Power(Long.parseLong(TMP_ARRAY[0]), Double.parseDouble(TMP_ARRAY[1]));
	}
}
