package work.modules;

import com.google.inject.AbstractModule;
import work.common.CommandLineParameterReader;
import work.config.ConfigReader;
import work.config.QuickTipAlgorithmAPConfig;
import work.config.QuickTipAlgorithmULAPConfig;
import work.config.QuickTipAlgorithmULConfig;

// https://www.baeldung.com/guice

public class QuickTipModule extends AbstractModule
{
  @Override
  protected void configure()
  {
    bind( CommandLineParameterReader.class);
    bind( ConfigReader.class);
    bind( QuickTipAlgorithmULConfig.class);
    bind( QuickTipAlgorithmAPConfig.class);
    bind(QuickTipAlgorithmULAPConfig.class);
  }
}