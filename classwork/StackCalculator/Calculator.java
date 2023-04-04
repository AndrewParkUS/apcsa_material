public class Calculator {
  // Implementation using a Stack
  
  Stack<Double> numbers = new Stack();
  
  // Evaluate a postfix expression stored in expression
  public static double eval (String expression) {
    // split expression by spaces into groups of expressions
    
    expressionlist = new ArrayList[expression.length]; //pseudocode
    for (int i = 0; i < expression.length; i++) {
      expressionlist[i] = expression.substring(i, i+1); 
    } 

    // Code Segment
    // If >2 operands, throw IllegalArgumentException("Too many operands");
    // If <2 operands, throw IllegalArgumentException("Too few operands for operation +");
    
    // for each group of expressions
    int operand1 = expression.substring[0]; // only takes first digit though
    int operand2 = expression.substring[1];
    String operator = expression.substring[expression.length-1];
    
    if (operator.equals("+")) {
      return operand1 + operand2;
    } else if (operator.equals("-")) {
      return operand1 - operand2;
    } else if (operator.equals("*")) {
      return operand1 * operand2;
    } else if (operator.equals("/")) {
      return operand1 / operand2;
    } else if (operator.equals("%")) {
      return operand1 % operand2;
    
    // if statements to figure out which operator to use
    return -1; // placeholder, operator should be different
  }
    
    
  
  // Method to convert infix to postfix expression
  public static String convert(String expression) {
    String postfix; 
    return postfix;
}
