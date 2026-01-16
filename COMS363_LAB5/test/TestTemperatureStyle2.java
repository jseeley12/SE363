import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestTemperatureStyle2 {

    private Temperature temp;
    private Humidity humid;
    private final int temperatureInput;
    private final int humidityInput;

    public TestTemperatureStyle2(int temperatureInput, int humidityInput) {
        this.temperatureInput = temperatureInput;
        this.humidityInput = humidityInput;
    }

    @Before
    public void setUp() {
        temp = new Temperature();  
        humid = new Humidity();
        Temperature.resetTemperature();
        Humidity.resetHumidity();
    }

   
    @Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
            {66, 10},  // Test 1: Pair 1
            {68, 20},  // Test 2: Pair 2
            {69, 30},  // Test 3: Pair 3
            {67, 40},  // Test 4: Pair 4
            {63, 50},  // Test 5: Pair 5
            {59, 60},  // Test 6: Pair 6
            {53, 70}   // Test 7: Pair 7
        });
    }

  
    @Test
    public void testTemperatureHumidity() {
       
        temp.setCurrentTemperature(temperatureInput);
        humid.setCurrentHumidity(humidityInput);
        humid.updateMaxMinHumidity();
        humid.updateStatusHumidity();
        humid.updateTrendHumidity();
        temp.updateMaxMinTemperature();
        temp.updateTrendTemperature();
        humid.printAllHumidity();
        temp.printAllTemperature();
        
        assertEquals(temperatureInput, temp.getCurrentTemperature());
    }
}
