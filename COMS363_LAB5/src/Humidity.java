
public class Humidity {

	private static int currentHumidity;
	private static int minHumidity = -1;
	private static int maxHumidity = 101;
	private static int previous = -1;
	private static String[] status = {"HIGH", "LOW", "OK"};
	private static String[] trend = {"Increasing", "Stable", "Decreasing", "NONE"};
	private static String trendNow;
	private static String statusNow;
	
	//gets current humidity
	public static int getCurrentHumidity() {
		
		return currentHumidity;
	}
	//sets current humidity
	public static void setCurrentHumidity(int current) {
		
		if(current < 0 || current > 150) {
			System.out.println("Humidity reading must be between 0-100 (%)");
		}else {
		currentHumidity = current;
		}
	}
	//gets min humidity
	public static int getMinHumidity() {
		
		return minHumidity;
	}
	//gets max humidity
	public static int getMaxHumidity() {
	
	return maxHumidity;
	}
	//gets trend of humidity
	public static String getTrendHumidity() {
		return trendNow;
	}
	//gets status of humidity
	public static String getStatusHumidity() {
		return statusNow;
	}
	
	//updates the maximum and minimum of humidity
	public static void updateMaxMinHumidity() {
		if(minHumidity == -1) {
			minHumidity = currentHumidity;
			maxHumidity = currentHumidity;
		}
		
	else if(currentHumidity >= previous) {
			maxHumidity = currentHumidity;
	} else if(currentHumidity <= minHumidity) {
			minHumidity = currentHumidity;
	}
	
	}
	
	//updates trend of humidity
	public static void updateTrendHumidity() {
		if(previous == -1) {
			trendNow = trend[3];
		}
		
		if(previous != -1) {
			
			if(currentHumidity > previous) {
				trendNow = trend[0];
			} else if(currentHumidity < previous) {
				trendNow = trend[2];
			} else {
				trendNow = trend[1];
			}
			
		}
		previous = currentHumidity;
	}
	//updates status of humidity
	public static void updateStatusHumidity() {
		if(currentHumidity >= 25 && currentHumidity <= 55) {
			statusNow = status[2];
		}else if(currentHumidity > 55) {
			statusNow = status[0];
		}else {
			statusNow = status[1];
		}
	}
	//resets humidity
	public static void resetHumidity() {
	
		minHumidity = -1;
		maxHumidity = 101;
		
	}
	//prints humidity data
	public static void printAllHumidity() {
		System.out.println("Current Humidity:  " + currentHumidity + "%");
		System.out.println("Maximum Humidity:  " + maxHumidity + "%");
		System.out.println("Minimum Humidity:  " + minHumidity + "%");
		System.out.println("Humidity Trend:  " + trendNow);
		System.out.println("Humidity Check:  " + statusNow);
		System.out.println();
	}
	
}
