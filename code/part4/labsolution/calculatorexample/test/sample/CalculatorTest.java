package sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
  private Calculator calculator;

  @BeforeEach
  void init() {
    calculator = new Calculator();
  }

  @Test
  void addTwoPositiveNumbers(){
    assertEquals(5, calculator.add(2, 3));
  }

  @Test
  void addTwoNegativeNumbers(){
    assertEquals(-5, calculator.add(-2, -3));
  }

  //more tests for overflow, etc. and different combination of signs, etc.

  @Test
  void divideTwoPositiveNumbers(){
    assertEquals(6, calculator.divide(12, 2));
  }

  @Test
  void divideByZero(){
    assertThrows(ArithmeticException.class, () ->
      calculator.divide(12, 0));
  }

  //changing int to double changes the behavior of the code in more than one way likely.
  //For example, double division does not throw an exception unlike int division. Do you want
  //users of your code, who wrote exception handling code, to endure the pain of this change?

  //This test helps us to know proactively that the code behaves differently. We now,
  //in order to preserve the behavior we expected, should check for denominator of 0
  //and throw an exception. Or find out if we should model a different behavior from the
  //application point of view. Also, think about backward compatiblity.

  //contract matters. What do the users of our code expect and rely upon.
}
