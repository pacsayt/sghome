package work.quicktip;

import org.xml.sax.SAXException;
import work.algorithms.AlgorithmFactory;
import work.algorithms.CommandLineparameters;
import work.algorithms.QuickTipAlgorithm;
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
  private AlgorithmFactory algorithmFactory;

  @Inject
  public QuickTip( CommandLineParameterReader iniCommandLineParameterReader, AlgorithmFactory iniAlgorithmFactory)
  {
    commandLineParameterReader = iniCommandLineParameterReader;
    algorithmFactory = iniAlgorithmFactory;
  }

  public void run( String[] args)
  {
    try
    {
      CommandLineparameters commandLineparameters = commandLineParameterReader.readCommandLineParameters( args);

      producePlaySlip(  algorithmFactory.getAlgorithm( commandLineparameters.getQuickTipAlgorithmNo()),
                        commandLineparameters);
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

  private void producePlaySlip(  QuickTipAlgorithm quickTipAlgorithm, CommandLineparameters commandLineparameters)
  {
    for ( int playSlipNo = 1 ; playSlipNo <= commandLineparameters.getAmountOfPlaySlips() ; playSlipNo++)
    {
      System.out.println( "Play slip #" + playSlipNo);
      System.out.println( quickTipAlgorithm.generatePlaySlip());
    }
  }

  private static void printUsage( String errorText)
  {
    System.err.println( errorText);
    System.err.println( "Usage : quickTip <amountOfPlaySlips> <quickTipAlgorithmNo>");
    System.err.println( "Both parameters must be positive integers.");
  }
}
