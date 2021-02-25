package work.algorithms;

import org.xml.sax.SAXException;
import work.common.CommandLineParameterReader;
import work.config.*;

import javax.inject.Inject;


public class AlgorithmFactory
{
  private ConfigReader configReader;

  @Inject
  public AlgorithmFactory( ConfigReader iniConfigReader)
  {
    configReader = iniConfigReader;
  }

  public QuickTipAlgorithm getAlgorithm( int typeOfAlgorithm) throws SAXException
  {
    QuickTipAlgorithm quickTipAlgorithm;

    switch ( typeOfAlgorithm )
    {
      case 1:
        quickTipAlgorithm = new QuickTipAlgorithm( new QuickTipAlgorithmULConfig( configReader));
        break;
      case 2:
        quickTipAlgorithm = new QuickTipAlgorithm( new QuickTipAlgorithmAPConfig( configReader));
        break;
      case 3:
        quickTipAlgorithm = new QuickTipAlgorithm( new QuickTipAlgorithmULAPConfig( configReader));
        break;
      default:
        quickTipAlgorithm = null;
    }

    return quickTipAlgorithm;
  }

//  public int configReader.getConfigurationValue( String algorithm, String parameter) throws SAXException, NumberFormatException
}
