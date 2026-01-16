import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Before;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestHumidityStyle1 {
	 private final int[][] inputPairs;
	    private int expectedFinalTemp = 0;
	    private int expectedFinalHumidity = 0;


	    public TestHumidityStyle1(int[][] inputPairs, int expectedFinalTemp, int expectedFinalHumidity) {
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
	                new int[][]{{10, 53}, {20, 51}, {30, 48}, {40, 49}, {50, 54}, {60, 56}, {70, 56}}, 
	                70,
	                56
	            }
	        });
	    }
	    @Test
	    public void testTemperatureHumidityMonitor() {
	        
	        for (int[] pair : inputPairs) {
	            Temperature.setCurrentTemperature(pair[0]);
	            Humidity.setCurrentHumidity(pair[1]);
	        }
	        //tests last value
	        assertEquals(expectedFinalHumidity, Humidity.getCurrentHumidity());
	     
	    }
	    
	}


