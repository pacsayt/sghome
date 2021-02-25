package work.config;

public class AbstractQuickTipAlgorithmARNConfig
{
  protected static final String AMOUNT_OF_RANDOM_NUMBERS_NAME = "amountRandomNumbers";

  protected int amountRandomNumbers;

  public AbstractQuickTipAlgorithmARNConfig()
  {

  }

  public int getAmountRandomNumbers()
  {
    return amountRandomNumbers;
  }

  public void setAmountRandomNumbers(int amountRandomNumbers)
  {
    this.amountRandomNumbers = amountRandomNumbers;
  }
}
