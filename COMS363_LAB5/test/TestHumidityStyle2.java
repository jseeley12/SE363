import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestHumidityStyle2 {
    private Temperature temp;
    private Humidity humid;
    private final int temperatureInput;
    private final int humidityInput;

    public TestHumidityStyle2(int temperatureInput, int humidityInput) {
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
            {10, 53},  // Test 1: Pair 1
            {20, 51},  // Test 2: Pair 2
            {30, 48},  // Test 3: Pair 3
            {40, 49},  // Test 4: Pair 4
            {50, 54},  // Test 5: Pair 5
            {60, 56},  // Test 6: Pair 6
            {70, 56}   // Test 7: Pair 7
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
        assertEquals(humidityInput, humid.getCurrentHumidity());
    }
}
