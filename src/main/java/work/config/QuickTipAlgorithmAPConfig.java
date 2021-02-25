package work.config;

import org.xml.sax.SAXException;

import javax.inject.Inject;

public class QuickTipAlgorithmAPConfig extends AbstractQuickTipAlgorithmARNConfig
{
  private static final String QUICK_TIP_ALGORITHM_AP_NAME = "quickTipAlgorithmAP";
  private static final String AMOUNT_OF_PANELS_NAME = "amountOfPanels";

  private int amountOfPanels;

  @Inject
  public QuickTipAlgorithmAPConfig( ConfigReader configReader) throws SAXException
  {
    amountRandomNumbers = configReader.getConfigurationValue( QUICK_TIP_ALGORITHM_AP_NAME, AMOUNT_OF_RANDOM_NUMBERS_NAME);
    amountOfPanels = configReader.getConfigurationValue( QUICK_TIP_ALGORITHM_AP_NAME, AMOUNT_OF_PANELS_NAME);
  }

  public int getAmountOfPanels()
  {
    return amountOfPanels;
  }
}
