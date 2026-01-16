import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
public class TemperatureHumidityTestA {
	
	//TR1
	@Test
	public void updateCurrentTempMultipleValues() {
		int temp1 = 10;
		int temp2 = 50;
		
		Temperature.setCurrentTemperature(temp1);
		Temperature.setCurrentTemperature(temp2);
		assertEquals(50 ,Temperature.getCurrentTemperature());
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void useOutOfBoundsValuesTemp() {
		int temp1 = 56;
		int temp2 = 120;
		int temp3 = -5; //out of bounds value
		
		Temperature.setCurrentTemperature(temp1);
		Temperature.setCurrentTemperature(temp2);
		Temperature.setCurrentTemperature(temp3);
		assertThat(Temperature.getCurrentTemperature(), equalTo(120));
		
	}
	//TR2
	@Test
	public void updateCurrentHumidityMultipleValues() {
		int humid1 = 82;
		int humid2 = 79;
		
		Humidity.setCurrentHumidity(humid1);
		Humidity.setCurrentHumidity(humid2);
		assertEquals(79 ,Humidity.getCurrentHumidity());
		
	}
	@SuppressWarnings("deprecation")
	@Test
	public void useOutOfBoundsValuesHumidity() {
		int humid1 = 56; //should be this
		int humid2 = 260; //out of bounds value
		int humid3 = -80; //out of bounds value
		
		Humidity.setCurrentHumidity(humid1);
		Humidity.setCurrentHumidity(humid2);
		Humidity.setCurrentHumidity(humid3);
		assertThat(Humidity.getCurrentHumidity(), equalTo(56));
		
	}
	//TR3
	@SuppressWarnings("deprecation")
	@Test
	public void trendsEachWayTemp() {
		int temp1 = 40;
		int temp2 = 32;
		int temp3 = 32;
		int temp4 = 80;
		
		Temperature.setCurrentTemperature(temp1);
		Temperature.updateTrendTemperature();
		Temperature.setCurrentTemperature(temp2);
		Temperature.updateTrendTemperature();
		assertThat(Temperature.getTrendTemperature(), equalTo("Decreasing"));
		Temperature.setCurrentTemperature(temp3);
		Temperature.updateTrendTemperature();
		assertThat(Temperature.getTrendTemperature(), equalTo("Stable"));
		Temperature.setCurrentTemperature(temp4);
		Temperature.updateTrendTemperature();
		assertThat(Temperature.getTrendTemperature(), equalTo("Increasing"));
		
	}
	@SuppressWarnings("deprecation")
	@Test
	public void trendsStayTheSameAndIncreaseTemp() {
	int temp1 = 1;
	int temp2 = 1;
	int temp3 = 149;
	
	Temperature.setCurrentTemperature(temp1);
	Temperature.updateTrendTemperature();
	assertThat(Temperature.getTrendTemperature(), equalTo("NONE")); //ADDED NONE FOR WHEN THERE IS NO TREND WHEN ONLY ONE VALUE IS READ and none to compare to
	Temperature.setCurrentTemperature(temp2);
	Temperature.updateTrendTemperature();
	assertThat(Temperature.getTrendTemperature(), equalTo("Stable"));
	Temperature.setCurrentTemperature(temp3);
	Temperature.updateTrendTemperature();
	assertThat(Temperature.getTrendTemperature(), equalTo("Increasing"));
}
	
	//TR4
	
	@SuppressWarnings("deprecation")
	@Test
	public void trendsEachWayHumidity() {
		int humid1 = 6;
		int humid2 = 6;
		int humid3 = 6;
		int humid4 = 80;
		int humid5= 75;
		Humidity.setCurrentHumidity(humid1);
		Humidity.updateTrendHumidity();
		Humidity.setCurrentHumidity(humid2);
		Humidity.updateTrendHumidity();
		assertThat(Humidity.getTrendHumidity(), equalTo("Stable"));
		Humidity.setCurrentHumidity(humid3);
		Humidity.updateTrendHumidity();
		assertThat(Humidity.getTrendHumidity(), equalTo("Stable"));
		Humidity.setCurrentHumidity(humid4);
		Humidity.updateTrendHumidity();
		assertThat(Humidity.getTrendHumidity(), equalTo("Increasing"));
		Humidity.setCurrentHumidity(humid5);
		Humidity.updateTrendHumidity();
		assertThat(Humidity.getTrendHumidity(), equalTo("Decreasing"));
		
	}
	@SuppressWarnings("deprecation")
	@Test
	public void trendsStayTheSameAndIncreaseHumidity() {
	int humid1 = 5;
	int humid2 = 5;
	int humid3 = 5;
	int humid4 = 98;
	
	Humidity.setCurrentHumidity(humid1);
	Humidity.updateTrendHumidity();
	assertThat(Humidity.getTrendHumidity(), equalTo("NONE")); //ADDED NONE FOR WHEN THERE IS NO TREND WHEN ONLY ONE VALUE IS READ and none to compare to
	Humidity.setCurrentHumidity(humid2);
	Humidity.updateTrendHumidity();
	assertThat(Humidity.getTrendHumidity(), equalTo("Stable"));
	Humidity.setCurrentHumidity(humid3);
	Humidity.updateTrendHumidity();
	assertThat(Humidity.getTrendHumidity(), equalTo("Stable"));
	Humidity.setCurrentHumidity(humid4);
	Humidity.updateTrendHumidity();
	assertThat(Humidity.getTrendHumidity(), equalTo("Increasing"));
}
	
	//TR5
	@Test
	public void threeSetsOfValues() {
	
		int humid1 = 11;
		int temp1 = 10;
		int humid2 = 89;
		int temp2 = 129;
		int humid3 = 46;
		int temp3 = 95;
		
		Humidity.setCurrentHumidity(humid1);
		Temperature.setCurrentTemperature(temp1);
		Temperature.updateMaxMinTemperature();
		Humidity.updateMaxMinHumidity();
		Humidity.setCurrentHumidity(humid2);
		Temperature.setCurrentTemperature(temp2);
		Temperature.updateMaxMinTemperature();
		Humidity.updateMaxMinHumidity();
		Humidity.setCurrentHumidity(humid3);
		Temperature.setCurrentTemperature(temp3);
		Temperature.updateMaxMinTemperature();
		Humidity.updateMaxMinHumidity();
		
		Temperature.resetTemperature();
		Humidity.resetHumidity();
		
		assertEquals(101, Humidity.getMaxHumidity()); //101 is the default value when reset and not displayed
		assertEquals(-1, Humidity.getMinHumidity()); //-1 is the default value when reset and not displayed
		assertEquals(151, Temperature.getMaxtemperature()); //151 is the default value when reset and not displayed
		assertEquals(-1, Temperature.getMinTemperature()); //-1 is the default value when reset and not displayed
	}
	@Test
	public void oneSetOfValues() {
		int humid1 = 78;
		int temp1 = 31;
		Humidity.setCurrentHumidity(humid1);
		Temperature.setCurrentTemperature(temp1);
		Temperature.updateMaxMinTemperature();
		Humidity.updateMaxMinHumidity();
		
		Temperature.resetTemperature();
		Humidity.resetHumidity();
		
		assertEquals(101, Humidity.getMaxHumidity()); //101 is the default value when reset and not displayed
		assertEquals(-1, Humidity.getMinHumidity()); //-1 is the default value when reset and not displayed
		assertEquals(151, Temperature.getMaxtemperature()); //151 is the default value when reset and not displayed
		assertEquals(-1, Temperature.getMinTemperature()); //-1 is the default value when reset and not displayed
		
	}
	//TR6
	@Test
	public void insertTwoSameValuesTemp() {
		int temp1 = 10;
		int temp2 = 10;
		Temperature.setCurrentTemperature(temp1);
		Temperature.updateMaxMinTemperature();
		Temperature.setCurrentTemperature(temp2);
		Temperature.updateMaxMinTemperature();
		assertEquals(10, Temperature.getMaxtemperature());
		Temperature.resetTemperature();
	}
	
	@Test
	public void insertThreeNoneSameValuesTemp() {
		int temp1 = 129;
		int temp2 = 60;
		int temp3 = 22;
		Temperature.setCurrentTemperature(temp1);
		Temperature.updateMaxMinTemperature();
		Temperature.setCurrentTemperature(temp2);
		Temperature.updateMaxMinTemperature();
		Temperature.setCurrentTemperature(temp3);
		Temperature.updateMaxMinTemperature();
		
		assertEquals(129, Temperature.getMaxtemperature());
		assertEquals(22, Temperature.getMinTemperature());
		Temperature.resetTemperature();
	}
	@Test
	public void insertOneValueTemp() {
		int temp1 = 2;
		Temperature.setCurrentTemperature(temp1);
		Temperature.updateMaxMinTemperature();
		
		assertEquals(2, Temperature.getMaxtemperature());
		assertEquals(2, Temperature.getMinTemperature());
		Temperature.resetTemperature();
	}
	
	@Test
	public void insertFourValuesTwoAreSameTemp() {
		int temp1 = 80;
		int temp2 = 145;
		int temp3 = 100;
		int temp4 =80;
		
		Temperature.setCurrentTemperature(temp1);
		Temperature.updateMaxMinTemperature();
		Temperature.setCurrentTemperature(temp2);
		Temperature.updateMaxMinTemperature();
		Temperature.setCurrentTemperature(temp3);
		Temperature.updateMaxMinTemperature();
		Temperature.setCurrentTemperature(temp4);
		Temperature.updateMaxMinTemperature();
		
		assertEquals(80, Temperature.getMinTemperature());
		Temperature.resetTemperature();
	}
	
	//TR7
	@Test
	public void insertTwoSameValuesHumidity() {
		int humid1 = 99;
		int humid2 = 99;
		Humidity.setCurrentHumidity(humid1);
		Humidity.updateMaxMinHumidity();
		Humidity.setCurrentHumidity(humid2);
		Humidity.updateMaxMinHumidity();
		assertEquals(99, Humidity.getMinHumidity());
		Humidity.resetHumidity();
	} 
	
	@Test
	public void insertThreeNoneSameValuesHumidity() {
		int humid1 = 49;
		int humid2 = 98;
		int humid3 = -1;
		Humidity.setCurrentHumidity(humid1);
		Humidity.updateMaxMinHumidity();
		Humidity.setCurrentHumidity(humid2);
		Humidity.updateMaxMinHumidity();
		Humidity.setCurrentHumidity(humid3);
		Humidity.updateMaxMinHumidity();
		
		assertEquals(98, Humidity.getMaxHumidity());
		assertEquals(49, Humidity.getMinHumidity());
		Humidity.resetHumidity();
	}
	@Test
	public void insertOneValueHumidity() {
		int humid1 = 76;
		Humidity.setCurrentHumidity(humid1);
		Humidity.updateMaxMinHumidity();
		
		assertEquals(76, Humidity.getMaxHumidity());
		assertEquals(76, Humidity.getMinHumidity());
		Humidity.resetHumidity();
	}
	
	@Test
	public void insertFourValuesTwoAreSameHumidity() {
		int humid1 = 44;
		int humid2 = 44;
		int humid3 = 44;
		int humid4 =80;
		
		Humidity.setCurrentHumidity(humid1);
		Humidity.updateMaxMinHumidity();
		Humidity.setCurrentHumidity(humid2);
		Humidity.updateMaxMinHumidity();
		Humidity.setCurrentHumidity(humid3);
		Humidity.updateMaxMinHumidity();
		Humidity.setCurrentHumidity(humid4);
		Humidity.updateMaxMinHumidity();
		
		assertEquals(44, Humidity.getMinHumidity());
		Humidity.resetHumidity();
	}
	
	//TR8
	
	@SuppressWarnings("deprecation")
	@Test
	public void checkOkStatus() {
		int humid1 = 45;
		int humid2 = 55;
		
		Humidity.setCurrentHumidity(humid1);
		Humidity.updateStatusHumidity();
		Humidity.getStatusHumidity();
		Humidity.setCurrentHumidity(humid2);
		Humidity.updateStatusHumidity();
		assertThat(Humidity.getStatusHumidity(), equalTo("OK"));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void checkHighStatus() {
		int humid1 = 10;
		int humid2 = 90;
		
		Humidity.setCurrentHumidity(humid1);
		Humidity.updateStatusHumidity();
		Humidity.getStatusHumidity();
		Humidity.setCurrentHumidity(humid2);
		Humidity.updateStatusHumidity();
		assertThat(Humidity.getStatusHumidity(), equalTo("HIGH"));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void checkLowStatus() {
		int humid1 = 80;
		int humid2 = 10;
		
		Humidity.setCurrentHumidity(humid1);
		Humidity.updateStatusHumidity();
		Humidity.getStatusHumidity();
		Humidity.setCurrentHumidity(humid2);
		Humidity.updateStatusHumidity();
		assertThat(Humidity.getStatusHumidity(), equalTo("LOW"));
	}
}



















