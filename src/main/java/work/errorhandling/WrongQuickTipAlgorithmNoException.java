package work.errorhandling;

public class WrongQuickTipAlgorithmNoException extends Exception
{
  public WrongQuickTipAlgorithmNoException( String iniExceptionText)
  {
    super( iniExceptionText); // Throwable::getMessage()
  }
}
