package work.config;

import org.xml.sax.SAXException;

import javax.inject.Inject;

public class QuickTipAlgorithmULConfig implements QuickTipAlgorithmConfig
{
  private int amountOfRandomNumbers;
  private int upperLimit;

  @Inject
  public QuickTipAlgorithmULConfig( ConfigReader configReader) throws SAXException
  {
    amountOfRandomNumbers = configReader.getConfigurationValue( QUICK_TIP_ALGORITHM_UL_NAME, AMOUNT_OF_RANDOM_NUMBERS_NAME);
    upperLimit = configReader.getConfigurationValue( QUICK_TIP_ALGORITHM_UL_NAME, UPPER_LIMIT_NAME);
  }

  @Override
  public int getAmountOfRandomNumbers()
  {
    return amountOfRandomNumbers;
  }

  @Override
  public int getUpperLimit()
  {
    return upperLimit;
  }
}
