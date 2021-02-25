package work.config;

import com.google.inject.Inject;
import org.xml.sax.SAXException;

public class QuickTipAlgorithmULAPConfig extends AbstractQuickTipAlgorithmARNConfig
{
  private static final String QUICK_TIP_ALGORITHM_ULAP_NAME = "quickTipAlgorithmULAP";
  private static final String UPPER_LIMIT_NAME = "upperLimit";
  private static final String AMOUNT_OF_PANELS_NAME = "amountOfPanels";

  private int upperLimit;
  private int amountOfPanels;

  @Inject
  public QuickTipAlgorithmULAPConfig( ConfigReader configReader) throws SAXException
  {
    amountRandomNumbers = configReader.getConfigurationValue( QUICK_TIP_ALGORITHM_ULAP_NAME, AMOUNT_OF_RANDOM_NUMBERS_NAME);
    upperLimit = configReader.getConfigurationValue( QUICK_TIP_ALGORITHM_ULAP_NAME, UPPER_LIMIT_NAME);
    amountOfPanels = configReader.getConfigurationValue( QUICK_TIP_ALGORITHM_ULAP_NAME, AMOUNT_OF_PANELS_NAME);
  }

  public int getUpperLimit()
  {
    return upperLimit;
  }

  public int getAmountOfPanels()
  {
    return amountOfPanels;
  }
}
