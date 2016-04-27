package fr.ujm.curien.krr.smart.generator.parser;

import fr.ujm.curien.krr.smart.generator.beans.Environmental;
import fr.ujm.curien.krr.smart.generator.beans.Generation;
import fr.ujm.curien.krr.smart.generator.beans.Power;

/**
 * Interface that defines method offered by a parser. A parser parses input data
 * from the three files.
 *
 * @author kammoun
 *
 */
public interface ParserI {
	/**
	 *
	 * @param line
	 * @return a {@link Environmental} of the line
	 */
	public Environmental parseEnvironmental(final String line);

	/**
	 *
	 * @param line
	 * @return a {@link Generation} of the line
	 */
	public Generation parseGeneration(final String line);

	/**
	 *
	 * @param line
	 * @return a {@link Power} of the line
	 */
	public Power parsePower(final String line);

}
