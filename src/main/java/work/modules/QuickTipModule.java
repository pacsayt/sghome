package work.modules;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import work.algorithms.AlgorithmFactory;
import work.common.CommandLineParameterReader;
import work.config.ConfigReader;

// https://www.baeldung.com/guice

public class QuickTipModule extends AbstractModule
{
  @Override
  protected void configure()
  {
    bind( String.class).annotatedWith( Names.named( "QuickTip.xsd")).toInstance("QuickTip.xsd");
    bind( String.class).annotatedWith( Names.named( "QuickTip.xml")).toInstance("QuickTip.xml");

    bind( CommandLineParameterReader.class);
    bind( ConfigReader.class);
    bind( AlgorithmFactory.class);
  }
}
