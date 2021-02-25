package work.config;

import org.xml.sax.SAXException;

import javax.inject.Inject;

public class QuickTipAlgorithmULConfig extends AbstractQuickTipAlgorithmARNConfig
{
  private static final String QUICK_TIP_ALGORITHM_UL_NAME = "quickTipAlgorithmUL";
  private static final String UPPER_LIMIT_NAME = "upperLimit";

  private int upperLimit;

  @Inject
  public QuickTipAlgorithmULConfig( ConfigReader configReader) throws SAXException
  {
    amountRandomNumbers = configReader.getConfigurationValue( QUICK_TIP_ALGORITHM_UL_NAME, AMOUNT_OF_RANDOM_NUMBERS_NAME);
    upperLimit = configReader.getConfigurationValue( QUICK_TIP_ALGORITHM_UL_NAME, UPPER_LIMIT_NAME);
  }

  public int getUpperLimit()
  {
    return upperLimit;
  }
}
