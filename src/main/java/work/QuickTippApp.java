package work;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.xml.sax.SAXException;
import work.modules.QuickTipModule;
import work.quicktip.QuickTip;


/**
 *
 */
public class QuickTippApp
{
  public static void main(String[] args) throws SAXException
  {
    Injector injector = Guice.createInjector( new QuickTipModule());
    QuickTip quickTip = injector.getInstance( QuickTip.class);

    quickTip.run( args);
  }
}
