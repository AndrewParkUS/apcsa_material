import java.util.Stack;

public class Calculator {
  public static double eval(String expression) {
    Stack<Double> stack = new Stack<>();
    String[] split = expression.split(" ");

    for (String bit : split) {
      if (bit.equals("+")) {
        if (stack.size() < 2) throw new IllegalArgumentException("Too few operands");
        double operand2 = stack.pop();
        double operand1 = stack.pop();
        stack.push(operand1 + operand2);

      } else if (bit.equals("-")) {
        if (stack.size() < 2) throw new IllegalArgumentException("Too few operands");
        double operand2 = stack.pop();
        double operand1 = stack.pop();
        stack.push(operand1 - operand2);

      } else if (bit.equals("*")) {
        if (stack.size() < 2) throw new IllegalArgumentException("Too few operands");
        double operand2 = stack.pop();
        double operand1 = stack.pop();
        stack.push(operand1 * operand2);

      } else if (bit.equals("/")) {
        if (stack.size() < 2) throw new IllegalArgumentException("Too few operands");
        double operand2 = stack.pop();
        double operand1 = stack.pop();
        stack.push(operand1 / operand2);

      } else if (bit.equals("%")) {
        if (stack.size() < 2) throw new IllegalArgumentException("Too few operands");
        double operand2 = stack.pop();
        double operand1 = stack.pop();
        stack.push(operand1 % operand2);

      } else {
        double operand = Double.parseDouble(bit);
        stack.push(operand);

      }
    }
    if (stack.size() != 1) throw new IllegalArgumentException("Too many operands");

    return stack.pop();
  }
}
