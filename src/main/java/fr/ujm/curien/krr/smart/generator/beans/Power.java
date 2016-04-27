package fr.ujm.curien.krr.smart.generator.beans;

import org.apache.commons.math3.util.Precision;

/**
 * 
 * @author kammoun
 *
 */
public class Power {
	final long timestampLocal;
	final double watts;
	double price;
	String source;

	public Power(long timestampLocal, double watts) {
		super();
		this.timestampLocal = timestampLocal;
		this.watts = watts;
		this.source = "fuel";
	}

	public long getTimestampLocal() {
		return timestampLocal;
	}

	public double getWatts() {
		return watts;
	}

	public double getPrice() {
		return price;
	}

	public String getSource() {
		return source;
	}

	public void setPrice(int lower, int upper) {
		this.price = (Precision.round( (Math.random() * (upper - lower)) + lower,4));
	}

	public String toRDF() {
		return "<http://www.smart.com/power#houseC> <http://www.smart.com/power#haspower> <http://www.smart.com/power#p> .\n"
				+ "<http://www.smart.com/power#p> <http://www.smart.com/watt> \"" + this.getWatts()
				+ "\"^^<http://www.w3.org/2001/XMLSchema#double> .\n" + "<http://www.smart.com/power#p> <http://www.smart.com/price> \""
				+ this.getPrice() + "\"^^<http://www.w3.org/2001/XMLSchema#double> .\n"
				+ "<http://www.smart.com/power#p> <http://www.smart.com/source> \"" + this.getSource()
				+ "\"^^<http://www.w3.org/2001/XMLSchema#string> .\n"
				+ "<http://www.smart.com/power#houseC> <http://www.smart.com/power#haslocation> <http://www.smart.com/location#l1> .\n";
	}

}
