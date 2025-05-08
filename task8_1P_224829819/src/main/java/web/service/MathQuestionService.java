package web.service;

public class MathQuestionService {

    /**
     * Calculate Q1 result (Addition) with input validation.
     */
    public static Double q1Addition(String number1, String number2) {
        return safeParseAndOperate(number1, number2, "+");
    }

    /**
     * Calculate Q2 result (Subtraction) with input validation.
     */
    public static Double q2Subtraction(String number1, String number2) {
        return safeParseAndOperate(number1, number2, "-");
    }

    /**
     * Calculate Q3 result (Multiplication) with input validation.
     */
    public static Double q3Multiplication(String number1, String number2) {
        return safeParseAndOperate(number1, number2, "*");
    }

    /**
     * Helper method for safe parsing and math operations.
     */
    private static Double safeParseAndOperate(String number1, String number2, String operation) {
        if (number1 == null || number2 == null || number1.isEmpty() || number2.isEmpty()) {
            return null;
        }
        try {
            double n1 = Double.parseDouble(number1);
            double n2 = Double.parseDouble(number2);

            switch (operation) {
                case "+": return n1 + n2;
                case "-": return n1 - n2;
                case "*": return n1 * n2;
                default: return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
