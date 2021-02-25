package work.errorhandling;

public class WrongAmountOfParametersException extends Exception
{
  public WrongAmountOfParametersException( String iniExceptionText)
  {
    super( iniExceptionText); // Throwable::getMessage()
  }
}