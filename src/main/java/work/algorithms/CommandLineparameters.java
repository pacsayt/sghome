package work.algorithms;

public class CommandLineparameters
{
  private int amountOfPlaySlips;
  private int quickTipAlgorithmNo;

  public CommandLineparameters(int iniAmountOfPlaySlips, int iniQuickTipAlgorithmNo)
  {
    amountOfPlaySlips = iniAmountOfPlaySlips;
    quickTipAlgorithmNo = iniQuickTipAlgorithmNo;
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