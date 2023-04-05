import java.util.Stack;

public class Calculator {
  public static String convert(String infix) {
   Stack<Double> stack = new Stack<>();
   String[] split = infix.split(" ");
   String[] operands = new String<>;
    
   for (String bit : split) {
    if (bit.equals("+") || bit.equals("-") || bit.equals("*") || bit.equals("/") || bit.equals("%")) { // modulo = multi/div > add/sub
      operands.add(bit); // pseudocode
      // parentheses not included
   
    } else {
      stack.push(bit);
    }
   +}
   // use elements in stack to convert to postfix?
   return stack.toString;
  }
  
  
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
