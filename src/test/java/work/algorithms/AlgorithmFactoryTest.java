package work.algorithms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.xml.sax.SAXException;
import work.config.ConfigReader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static work.config.QuickTipAlgorithmConfig.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AlgorithmFactoryTest
{
  private ConfigReader mockConfigReader;

  @BeforeAll
  public void setUpMock() throws SAXException
  {
    mockConfigReader = mock( ConfigReader.class);

    when( mockConfigReader.getConfigurationValue( QUICK_TIP_ALGORITHM_AP_NAME, AMOUNT_OF_RANDOM_NUMBERS_NAME)).thenReturn( 10);
    when( mockConfigReader.getConfigurationValue( QUICK_TIP_ALGORITHM_AP_NAME, AMOUNT_OF_PANELS_NAME)).thenReturn( 5);

    when( mockConfigReader.getConfigurationValue( QUICK_TIP_ALGORITHM_ULAP_NAME, AMOUNT_OF_RANDOM_NUMBERS_NAME)).thenReturn( 5);
    when( mockConfigReader.getConfigurationValue( QUICK_TIP_ALGORITHM_ULAP_NAME, UPPER_LIMIT_NAME)).thenReturn( 10);
    when( mockConfigReader.getConfigurationValue( QUICK_TIP_ALGORITHM_ULAP_NAME, AMOUNT_OF_PANELS_NAME)).thenReturn( 3);

    when( mockConfigReader.getConfigurationValue( QUICK_TIP_ALGORITHM_UL_NAME, AMOUNT_OF_RANDOM_NUMBERS_NAME)).thenReturn( 5);
    when( mockConfigReader.getConfigurationValue( QUICK_TIP_ALGORITHM_UL_NAME, UPPER_LIMIT_NAME)).thenReturn( 90);
  }

  @Test
  public void testAlgorithmULCreation() throws SAXException
  {
    AlgorithmFactory algorithmFactory = new AlgorithmFactory( mockConfigReader);

    QuickTipAlgorithm quickTipAlgorithm = algorithmFactory.getAlgorithm( 1); // QuickTipAlgorithmUL

    String playSlip = quickTipAlgorithm.generatePlaySlip();

    System.out.println( playSlip);

    assertEquals( 4, playSlip.chars().filter(ch -> ch == ',' ).count());
    assertEquals( -1, playSlip.indexOf( "] , ["));
  }

  @Test
  public void testAlgorithmAPCreation() throws SAXException
  {
    AlgorithmFactory algorithmFactory = new AlgorithmFactory( mockConfigReader);

    QuickTipAlgorithm quickTipAlgorithm = algorithmFactory.getAlgorithm( 2); // QuickTipAlgorithmAP

    String playSlip = quickTipAlgorithm.generatePlaySlip();

    System.out.println( playSlip);

    assertEquals( 49, playSlip.chars().filter(ch -> ch == ',').count());
    assertEquals( 4, countSlips( playSlip));

//    String parts[] = playSlip.split( ", ");
  }

  @Test
  public void testAlgorithmULAPCreation() throws SAXException
  {
    AlgorithmFactory algorithmFactory = new AlgorithmFactory( mockConfigReader);

    QuickTipAlgorithm quickTipAlgorithm = algorithmFactory.getAlgorithm( 3); // QuickTipAlgorithmAP

    String playSlip = quickTipAlgorithm.generatePlaySlip();

    System.out.println( playSlip);

    assertEquals( 14, playSlip.chars().filter(ch -> ch == ',').count());
    assertEquals( 2, countSlips( playSlip));

//    String parts[] = playSlip.split( ", ");
  }

  private int countSlips( String slip)
  {
    int count = 0;
    int pos = 0;

    while ( (pos = slip.indexOf( "] , [", pos)) != -1 )
    {
      pos = pos + "] , [".length() - 1; // to avoid index out of bounds
      count++;
    }

    return count;
  }
}
