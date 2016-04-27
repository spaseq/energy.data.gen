package fr.ujm.curien.krr.smart.generator.beans;

/**
 * 
 * @author kammoun
 *
 */
public class Environmental {
	final long timestampLocal;
	final double temperature;
	final int humidity;
	final double dewpoint;
	final double barometer;
	final int windspeed;
	final int gustspeed;
	final int direction;
	final double rainlastmin;
	final double dailyrain;
	final double monthlyrain;
	final double yearlyrain;
	final double heatindex;

	public Environmental(long timestampLocal, double temperature, int humidity, double dewpoint, double barometer,
			int windspeed, int gustspeed, int direction, double rainlastmin, double dailyrain, double monthlyrain,
			double yearlyrain, double heatindex) {
		super();
		this.timestampLocal = timestampLocal;
		this.temperature = temperature;
		this.humidity = humidity;
		this.dewpoint = dewpoint;
		this.barometer = barometer;
		this.windspeed = windspeed;
		this.gustspeed = gustspeed;
		this.direction = direction;
		this.rainlastmin = rainlastmin;
		this.dailyrain = dailyrain;
		this.monthlyrain = monthlyrain;
		this.yearlyrain = yearlyrain;
		this.heatindex = heatindex;
	}

	public long getTimestampLocal() {
		return timestampLocal;
	}

	public double getTemperature() {
		return temperature;
	}

	public int getHumidity() {
		return humidity;
	}

	public double getDewpoint() {
		return dewpoint;
	}

	public double getBarometer() {
		return barometer;
	}

	public int getWindspeed() {
		return windspeed;
	}

	public int getGustspeed() {
		return gustspeed;
	}

	public int getDirection() {
		return direction;
	}

	public double getRainlastmin() {
		return rainlastmin;
	}

	public double getDailyrain() {
		return dailyrain;
	}

	public double getMonthlyrain() {
		return monthlyrain;
	}

	public double getYearlyrain() {
		return yearlyrain;
	}

	public double getHeatindex() {
		return heatindex;
	}

	public String toRDF() {
		return "<http://www.smart.com/environmental#weather> <http://www.smart.com/environmental#hasvalue> <http://www.smart.com/environmental#value> . \n"
				+ "<http://www.smart.com/environmental#value> <http://www.smart.com/windspeed> \"" + this.getWindspeed()
				+ "\"^^<http://www.w3.org/2001/XMLSchema#integer> .\n"
				+ "<http://www.smart.com/environmental#value> <http://www.smart.com/heatindex> \"" + this.getHeatindex()
				+ "\"^^<http://www.w3.org/2001/XMLSchema#double> .\n"
				+ "<http://www.smart.com/environmental#value> <http://www.smart.com/gustspeed> \"" + this.getGustspeed()
				+ "\"^^<http://www.w3.org/2001/XMLSchema#integer> .\n"
				+ "<http://www.smart.com/environmental#weather> <http://www.smart.com/environmental#haslocation>  <http://www.smart.com/location#l1> .\n";
	}
}
