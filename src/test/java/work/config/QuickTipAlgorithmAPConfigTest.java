package work.config;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static work.config.QuickTipAlgorithmConfig.*;

public class QuickTipAlgorithmAPConfigTest
{
  @Test
  public void testConfigParameterReadingAndDefault() throws SAXException
  {
    ConfigReader mockConfigReader = mock( ConfigReader.class);

    when( mockConfigReader.getConfigurationValue( QUICK_TIP_ALGORITHM_AP_NAME, AMOUNT_OF_RANDOM_NUMBERS_NAME)).thenReturn( 10);
    when( mockConfigReader.getConfigurationValue( QUICK_TIP_ALGORITHM_AP_NAME, AMOUNT_OF_PANELS_NAME)).thenReturn( 5);

    QuickTipAlgorithmAPConfig quickTipAlgorithmAPConfig = new QuickTipAlgorithmAPConfig( mockConfigReader);

    // Assertions.assertEquals() -> AssertEquals.assertEquals() <- is not public in the package
    assertEquals( 5, quickTipAlgorithmAPConfig.getAmountOfPanels());
    assertEquals( 10, quickTipAlgorithmAPConfig.getAmountOfRandomNumbers());
    assertEquals( 90, quickTipAlgorithmAPConfig.getUpperLimit());
  }
}
