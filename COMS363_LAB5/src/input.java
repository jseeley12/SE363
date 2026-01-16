import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class input {
	private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	 //MAIN FUNCTION
	public static void main(String args[]) {
		Scanner scnr = new Scanner(System.in);
		int humiditySensorReading;
		int temperatureSensorReading;
	// THIS IS THE INTERVALS IN WHICH THE SENSORS WILL INTAKE READINGS	
	//	scheduler.scheduleAtFixedRate(input::TakeReading, 0, 30, TimeUnit.SECONDS);  
		
		
		while(true) { //MY SENSOR READING INTERVALS WILL HAPPEN BY EACH USER INPUT FOR TESTING
		System.out.println("Please enter 'input' to enter new readings, or 'reset' to reset values, or 'quit' to quit simulation"); 
		String s = scnr.nextLine();
		if(s.equalsIgnoreCase("quit")) {
			break;
		}else if(s.equalsIgnoreCase("reset")) {
			Humidity.resetHumidity();
			Temperature.resetTemperature();
			continue;
		}else if(s.equalsIgnoreCase("input")){
			while(true) {
			System.out.println("Enter Temperature (0-150F): ");
			s = scnr.nextLine();
			temperatureSensorReading = Integer.parseInt(s);
			System.out.println("Enter Humidity (0-100%): ");
			s = scnr.nextLine();
			humiditySensorReading = Integer.parseInt(s);
			if(temperatureSensorReading < 0 || temperatureSensorReading > 150 || humiditySensorReading < 0 || humiditySensorReading > 100) {
				System.out.println("One of the values you inputted is invalid try again! Temperature should be (0-150F) and humidity should be (0-100%)");
				continue;
			}else {
				break;
			}
			}
			Temperature.setCurrentTemperature(temperatureSensorReading);
			Temperature.updateMaxMinTemperature();
			Temperature.updateTrendTemperature();
			Humidity.setCurrentHumidity(humiditySensorReading);
			Humidity.updateMaxMinHumidity();
			Humidity.updateStatusHumidity();
			Humidity.updateTrendHumidity();
			
			System.out.println("Temperature/Humidity Monitor Readings:");
			Humidity.printAllHumidity();
			Temperature.printAllTemperature();
		} else {
			System.out.println("Invalid input! Please Enter one of the options given!");
			
		}
	}
		
		scnr.close();
	}
	//ONCE HARDWARE IS INCLUDED MOST OF THE CODE IN THE MAIN WILL BE INTEGRATED INTO HERE FOR THE SENSOR TO BE GIVING READS AUTOMATICALLY
	public static void TakeReading(){
		
	}
}
