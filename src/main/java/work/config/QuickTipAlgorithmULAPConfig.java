package work.config;

import com.google.inject.Inject;
import org.xml.sax.SAXException;

public class QuickTipAlgorithmULAPConfig implements QuickTipAlgorithmConfig
{
  private int amountOfRandomNumbers;
  private int upperLimit;
  private int amountOfPanels;

  @Inject
  public QuickTipAlgorithmULAPConfig( ConfigReader configReader) throws SAXException
  {
    amountOfRandomNumbers = configReader.getConfigurationValue( QUICK_TIP_ALGORITHM_ULAP_NAME, AMOUNT_OF_RANDOM_NUMBERS_NAME);
    upperLimit = configReader.getConfigurationValue( QUICK_TIP_ALGORITHM_ULAP_NAME, UPPER_LIMIT_NAME);
    amountOfPanels = configReader.getConfigurationValue( QUICK_TIP_ALGORITHM_ULAP_NAME, AMOUNT_OF_PANELS_NAME);
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

  @Override
  public int getAmountOfPanels()
  {
    return amountOfPanels;
  }
}
