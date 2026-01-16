
public class Temperature {
	
	private static int currentTemperature;
	private static int minTemperature = -1;
	private static int maxTemperature = 151;
	private static int previous = -1;
	private static String[] trend = {"Increasing", "Stable", "Decreasing", "NONE"};
	private static String trendNow;
	
	//Gets current temp
	public static int getCurrentTemperature() {
		
		return currentTemperature;
	}
	//Gets min temp
	public static int getMinTemperature() {
		
		return minTemperature;
	}
	
	//gets max temp
	public static int getMaxtemperature() {
	
	return maxTemperature;
	}
	
	//gets temp trend
	public static String getTrendTemperature() {
		return trendNow;
	}
	//sets current temp
	public static void setCurrentTemperature(int current) {
		
		if(current < 0 || current > 150) {
			System.out.println("Temperature reading must be between 0-150 (Fahrenheit)");
		}else {
		currentTemperature = current;
		}
	}
	//updates the max and min for temp
	public static void updateMaxMinTemperature() {
		if(minTemperature == -1) {
			minTemperature = currentTemperature;
			maxTemperature = currentTemperature;
		}
		
	else if(currentTemperature >= previous) {
			maxTemperature = currentTemperature;
	} else if(currentTemperature <= minTemperature) {
			minTemperature = currentTemperature;
	}
	}
	
	//updates trend of the temp
	public static void updateTrendTemperature() {
		if(previous == -1) {
			trendNow = trend[3];
		}
		
		if(previous != -1) {
			
			if(currentTemperature > previous) {
				trendNow = trend[0];
			} else if(currentTemperature < previous) {
				trendNow = trend[2];
			} else {
				trendNow = trend[1];
			}
			
		}
		previous = currentTemperature;
	}
	
	//resets temp
	public static void resetTemperature() {
		
		minTemperature = -1;
		maxTemperature = 151;
		
	}
	//prints temperature values
	public static void printAllTemperature() {
		System.out.println("Current Temperature:  " + currentTemperature + "%");
		System.out.println("Maximum Temperature:  " + maxTemperature + "%");
		System.out.println("Minimum Temperature:  " + minTemperature + "%");
		System.out.println("Temperature Trend:  " + trendNow);

	}
}
