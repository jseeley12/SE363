import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Before;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestTemperatureStyle1 {

	    private final int[][] inputPairs;
	    private int expectedFinalTemp = 0;
	    private int expectedFinalHumidity = 0;


	    public TestTemperatureStyle1(int[][] inputPairs, int expectedFinalTemp, int expectedFinalHumidity) {
	        this.inputPairs = inputPairs;
	        this.expectedFinalTemp = expectedFinalTemp;
	        this.expectedFinalHumidity = expectedFinalHumidity;
	    }

	    @Before
	    public void setUp() {
	       Temperature.resetTemperature();
	       Humidity.resetHumidity();
	    }

	    @Parameters
	    public static Collection<Object[]> parameters() {
	        return Arrays.asList(new Object[][]{
	            {
	                // Pairs
	                new int[][]{{66, 97}, {68, 51}, {69, 91}, {67, 49}, {63, 79}, {59, 56}, {53, 88}}, 
	                53,
	                88
	            }
	        });
	    }
	    @Test
	    public void testTemperatureHumidityMonitor() {
	        
	        for (int[] pair : inputPairs) {
	            Temperature.setCurrentTemperature(pair[0]);
	            Humidity.setCurrentHumidity(pair[1]);
	        }

	        assertEquals(expectedFinalTemp, Temperature.getCurrentTemperature());
	     
	    }
	    
	    
	}


