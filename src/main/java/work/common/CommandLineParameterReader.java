package work.common;

import work.errorhandling.WrongAmountOfParametersException;
import work.errorhandling.WrongAmountOfPlaySlipsException;
import work.errorhandling.WrongQuickTipAlgorithmNoException;

import java.security.InvalidParameterException;

public class CommandLineParameterReader
{
  private static int AMOUNT_OF_PLAY_SLIPS_IDX = 0;
  private static int AMOUNT_OF_QUICK_TIP_ALGORITHM_NO_IDX = 1;

  private int amountOfPlaySlips;
  private int quickTipAlgorithmNo;

  public void readCommandLineParameters( String[] commandLineParameters) throws WrongAmountOfPlaySlipsException, WrongQuickTipAlgorithmNoException, WrongAmountOfParametersException
  {
    if ( commandLineParameters.length != 2 )
    {
      throw new WrongAmountOfParametersException( "Wrong amount of parameters.");
    }

    try
    {
      amountOfPlaySlips = Integer.parseInt(commandLineParameters[AMOUNT_OF_PLAY_SLIPS_IDX]);
    }
    catch( NumberFormatException numberFormatException)
    {
      throw new WrongAmountOfPlaySlipsException( numberFormatException.getMessage());
    }

    try
    {
      quickTipAlgorithmNo = Integer.parseInt(commandLineParameters[AMOUNT_OF_QUICK_TIP_ALGORITHM_NO_IDX]);
    }
    catch( NumberFormatException numberFormatException)
    {
      throw new WrongQuickTipAlgorithmNoException( numberFormatException.getMessage());
    }
  }

  public int getAmountOfPlaySlips()
  {
    return amountOfPlaySlips;
  }

  public int getQuickTipAlgorithmNo()
  {
    return quickTipAlgorithmNo;
  }
}