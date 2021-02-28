package work.config;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static work.config.QuickTipAlgorithmConfig.*;

public class QuickTipAlgorithmULConfigTest
{
  @Test
  public void testConfigParameterReadingAndDefault() throws SAXException
  {
    ConfigReader mockConfigReader = mock( ConfigReader.class);

    when( mockConfigReader.getConfigurationValue( QUICK_TIP_ALGORITHM_UL_NAME, AMOUNT_OF_RANDOM_NUMBERS_NAME)).thenReturn( 5);
    when( mockConfigReader.getConfigurationValue( QUICK_TIP_ALGORITHM_UL_NAME, AMOUNT_OF_PANELS_NAME)).thenReturn( 5);
    when( mockConfigReader.getConfigurationValue( QUICK_TIP_ALGORITHM_UL_NAME, UPPER_LIMIT_NAME)).thenReturn( 10);

    QuickTipAlgorithmULConfig quickTipAlgorithmULAPConfig = new QuickTipAlgorithmULConfig( mockConfigReader);

    // Assertions.assertEquals() -> AssertEquals.assertEquals() <- is not public in the package
    assertEquals( 1, quickTipAlgorithmULAPConfig.getAmountOfPanels());
    assertEquals( 5, quickTipAlgorithmULAPConfig.getAmountOfRandomNumbers());
    assertEquals( 10, quickTipAlgorithmULAPConfig.getUpperLimit());
  }
}
