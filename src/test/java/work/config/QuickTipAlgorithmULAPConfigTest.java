package work.config;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static work.config.QuickTipAlgorithmConfig.*;

public class QuickTipAlgorithmULAPConfigTest
{
  @Test
  public void testConfigParameterReading() throws SAXException
  {
    ConfigReader mockConfigReader = mock( ConfigReader.class);

    when( mockConfigReader.getConfigurationValue( QUICK_TIP_ALGORITHM_ULAP_NAME, AMOUNT_OF_RANDOM_NUMBERS_NAME)).thenReturn( 5);
    when( mockConfigReader.getConfigurationValue( QUICK_TIP_ALGORITHM_ULAP_NAME, AMOUNT_OF_PANELS_NAME)).thenReturn( 5);
    when( mockConfigReader.getConfigurationValue( QUICK_TIP_ALGORITHM_ULAP_NAME, UPPER_LIMIT_NAME)).thenReturn( 10);

    QuickTipAlgorithmULAPConfig quickTipAlgorithmULAPConfig = new QuickTipAlgorithmULAPConfig( mockConfigReader);

    // Assertions.assertEquals() -> AssertEquals.assertEquals() <- is not public in the package
    assertEquals( 5, quickTipAlgorithmULAPConfig.getAmountOfPanels());
    assertEquals( 5, quickTipAlgorithmULAPConfig.getAmountOfRandomNumbers());
    assertEquals( 10, quickTipAlgorithmULAPConfig.getUpperLimit());
  }
}
