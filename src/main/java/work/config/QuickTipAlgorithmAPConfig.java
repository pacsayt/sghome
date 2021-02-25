package work.config;

import org.xml.sax.SAXException;

import javax.inject.Inject;

public class QuickTipAlgorithmAPConfig implements QuickTipAlgorithmConfig
{
  private int amountOfRandomNumbers;
  private int amountOfPanels;

  @Inject
  public QuickTipAlgorithmAPConfig( ConfigReader configReader) throws SAXException
  {
    amountOfRandomNumbers = configReader.getConfigurationValue( QUICK_TIP_ALGORITHM_AP_NAME, AMOUNT_OF_RANDOM_NUMBERS_NAME);
    amountOfPanels = configReader.getConfigurationValue( QUICK_TIP_ALGORITHM_AP_NAME, AMOUNT_OF_PANELS_NAME);
  }

  @Override
  public int getAmountOfRandomNumbers()
  {
    return amountOfRandomNumbers;
  }

  @Override
  public int getAmountOfPanels()
  {
    return amountOfPanels;
  }

}
