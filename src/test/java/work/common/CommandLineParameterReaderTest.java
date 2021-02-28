package work.common;

import org.junit.jupiter.api.Test;
import work.algorithms.CommandLineparameters;
import work.errorhandling.WrongAmountOfParametersException;
import work.errorhandling.WrongAmountOfPlaySlipsException;
import work.errorhandling.WrongQuickTipAlgorithmNoException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommandLineParameterReaderTest
{
  @Test
  public void testGoodCase() throws WrongAmountOfParametersException, WrongAmountOfPlaySlipsException, WrongQuickTipAlgorithmNoException
  {
    String commandLine[] = { "1", "2"};

    CommandLineparameters commandLineparameters = new CommandLineParameterReader().readCommandLineParameters( commandLine);

    assertEquals( 1, commandLineparameters.getAmountOfPlaySlips());
    assertEquals( 2, commandLineparameters.getQuickTipAlgorithmNo());
  }

  @Test
  public void testIncorrectAmountOfParams() throws WrongAmountOfParametersException, WrongAmountOfPlaySlipsException, WrongQuickTipAlgorithmNoException
  {
    String commandLine[] = { "1", "2", "3"};

    assertThrows( WrongAmountOfParametersException.class, () -> new CommandLineParameterReader().readCommandLineParameters( commandLine));
  }

  @Test
  public void testIncorrectFormatOfAmountOfPlaySlips() throws WrongAmountOfParametersException, WrongAmountOfPlaySlipsException, WrongQuickTipAlgorithmNoException
  {
    String commandLine[] = { "a", "2"};

    assertThrows( WrongAmountOfPlaySlipsException.class, () -> new CommandLineParameterReader().readCommandLineParameters( commandLine));
  }

  @Test
  public void testIncorrectFormatOfQuickTipAlgorithm() throws WrongAmountOfParametersException, WrongAmountOfPlaySlipsException, WrongQuickTipAlgorithmNoException
  {
    String commandLine[] = { "1", "b"};

    assertThrows( WrongQuickTipAlgorithmNoException.class, () -> new CommandLineParameterReader().readCommandLineParameters( commandLine));
  }
}