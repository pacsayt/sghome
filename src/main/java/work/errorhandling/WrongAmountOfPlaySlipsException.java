package work.errorhandling;

public class WrongAmountOfPlaySlipsException extends Exception
{
  public WrongAmountOfPlaySlipsException( String iniExceptionText)
  {
    super( iniExceptionText);
  }
}
