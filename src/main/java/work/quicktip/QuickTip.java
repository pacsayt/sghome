package work.quicktip;

import org.xml.sax.SAXException;
import work.common.CommandLineParameterReader;
import work.config.ConfigReader;
import work.errorhandling.WrongAmountOfParametersException;
import work.errorhandling.WrongAmountOfPlaySlipsException;
import work.errorhandling.WrongQuickTipAlgorithmNoException;

import javax.inject.Inject;

/*
   It is provided that the configuration XML and XSD files are in the actual directory,
   with the following names :
   QuickTip.xml - the configuration file
   QuickTip.xsd - the configuration file's schema
 */
public class QuickTip
{
  private CommandLineParameterReader commandLineParameterReader;
  private ConfigReader configReader;

  @Inject
  public QuickTip( CommandLineParameterReader iniCommandLineParameterReader, ConfigReader iniConfigReader)
  {
    commandLineParameterReader = iniCommandLineParameterReader;
    configReader = iniConfigReader;
  }

  public void run( String[] args)
  {
    try
    {
      commandLineParameterReader.readCommandLineParameters( args);

      configReader.readConfiguration();

    }
    catch ( WrongAmountOfPlaySlipsException wrongAmountOfPlaySlipsException )
    {
      printUsage( wrongAmountOfPlaySlipsException.getMessage());
    }
    catch ( WrongQuickTipAlgorithmNoException wrongQuickTipAlgorithmNoException )
    {
      printUsage( wrongQuickTipAlgorithmNoException.getMessage());
    }
    catch ( WrongAmountOfParametersException wrongAmountOfParametersException )
    {
      printUsage( wrongAmountOfParametersException.getMessage());
    } catch ( SAXException e )
    {
      e.printStackTrace();
    }
  }

  private static void printUsage( String errorText)
  {
    System.err.println( errorText);
    System.err.println( "Usage : quickTip <amountOfPlaySlips> <quickTipAlgorithmNo>");
    System.err.println( "Both parameters must be positive integers.");
  }
}
