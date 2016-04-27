package fr.ujm.curien.krr.smart.generator.beans;

import org.apache.commons.math3.util.Precision;

/**
 * 
 * @author kammoun
 *
 */
public class Generation {

	final long timestampUTC;
	final double turbine1mAmps,turbine2mAmps, panel1mAmps, panel2mAmps, panel3mAmps, batteryVolts;
	double price;
	String source;

	public Generation(long timestampUTC, double turbine1mAmps, double turbine2mAmps, double panel1mAmps,
			double panel2mAmps, double panel3mAmps, double batteryVolts) {
		super();
		this.timestampUTC = timestampUTC;
		this.turbine1mAmps = turbine1mAmps;
		this.turbine2mAmps = turbine2mAmps;
		this.panel1mAmps = panel1mAmps;
		this.panel2mAmps = panel2mAmps;
		this.panel3mAmps = panel3mAmps;
		this.batteryVolts = batteryVolts;
		this.source = "renewable";
		this.price = 0;
	}

	public long getTimestampUTC() {
		return timestampUTC;
	}

	public double getTurbine1mAmps() {
		return turbine1mAmps;
	}

	public double getTurbine2mAmps() {
		return turbine2mAmps;
	}

	public double getPanel1mAmps() {
		return panel1mAmps;
	}

	public double getPanel2mAmps() {
		return panel2mAmps;
	}

	public double getPanel3mAmps() {
		return panel3mAmps;
	}

	public double getBatteryVolts() {
		return batteryVolts;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(int lower, int upper) {
		this.price= Precision.round( (Math.random() * (upper - lower)) + lower,4);
	}

	public String getSource() {
		return source;
	}

	public String toRDF() {
		return "<http://www.smart.com/power#houseC> <http://www.smart.com/power#haspower> <http://www.smart.com/power#p> .\n"
				+ "<http://www.smart.com/power#p> <http://www.smart.com/watt> \"" + this.getBatteryVolts()
				+ "\"^^<http://www.w3.org/2001/XMLSchema#double> .\n" + "<http://www.smart.com/power#p> <http://www.smart.com/price> \""
				+ this.getPrice() + "\"^^<http://www.w3.org/2001/XMLSchema#double> .\n"
				+ "<http://www.smart.com/power#p> <http://www.smart.com/source> \"" + this.getSource()
				+ "\"^^<http://www.w3.org/2001/XMLSchema#string> .\n"
				+ " <http://www.smart.com/power#houseC> <http://www.smart.com/power#haslocation> <http://www.smart.com/location#l1> .\n";
	}
}
