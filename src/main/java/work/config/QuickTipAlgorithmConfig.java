package work.config;

public interface QuickTipAlgorithmConfig
{
  String QUICK_TIP_ALGORITHM_UL_NAME = "quickTipAlgorithmUL";
  String QUICK_TIP_ALGORITHM_AP_NAME = "quickTipAlgorithmAP";
  String QUICK_TIP_ALGORITHM_ULAP_NAME = "quickTipAlgorithmULAP";

  String AMOUNT_OF_RANDOM_NUMBERS_NAME = "amountRandomNumbers";
  String UPPER_LIMIT_NAME = "upperLimit";
  String AMOUNT_OF_PANELS_NAME = "amountOfPanels";

  default int getAmountOfRandomNumbers()
  {
    return 5;
  }

  default int getUpperLimit()
  {
    return 90;
  }

  default int getAmountOfPanels()
  {
    return 1;
  }
}
