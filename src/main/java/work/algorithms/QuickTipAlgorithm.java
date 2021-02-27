package work.algorithms;

import work.config.QuickTipAlgorithmConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class QuickTipAlgorithm
{
  private QuickTipAlgorithmConfig quickTipAlgorithmARNConfig;

  public QuickTipAlgorithm( QuickTipAlgorithmConfig iniQuickTipAlgorithmARNConfig)
  {
    quickTipAlgorithmARNConfig = iniQuickTipAlgorithmARNConfig;
  }

  public void generatePlaySlip()
  {
    List<String > panels = new ArrayList<>();

    for ( int i = 0; i < quickTipAlgorithmARNConfig.getAmountOfPanels() ; i++ )
    {
      String onePanel = new Random().ints(1, quickTipAlgorithmARNConfig.getUpperLimit())
                                    .distinct()
                                    .limit( quickTipAlgorithmARNConfig.getAmountOfRandomNumbers())
                                    .sorted()
                                    .mapToObj( Integer::toString)
                                    .collect( Collectors.joining(", "));

      panels.add( onePanel);
    }

    String oneSlip = panels.stream().collect( Collectors.joining( "] , [", "[[","]]"));

    System.out.println( oneSlip);
  }
}
