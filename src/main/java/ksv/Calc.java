package ksv;

public class Calc {
    public static <T extends Number, U extends Number> T sum(T num1, U num2) {
        double result = num1.doubleValue() + num2.doubleValue();
        return convertResult(num1, result);
    }

    public static <T extends Number, U extends Number> T multiply(T num1, U num2) {
        double result = num1.doubleValue() * num2.doubleValue();
        return convertResult(num1, result);
    }

    public static <T extends Number, U extends Number> T divide(T num1, U num2) {
        if (num2.doubleValue() == 0) {
            throw new ArithmeticException("Division by zero");
        }
        double result = num1.doubleValue() / num2.doubleValue();
        return convertResult(num1, result);
    }

    public static <T extends Number, U extends Number> T subtract(T num1, U num2) {
        double result = num1.doubleValue() - num2.doubleValue();
        return convertResult(num1, result);
    }

    private static <T extends Number> T convertResult(T num1, double result) {
        if (num1 instanceof Integer) {
            return (T) Integer.valueOf((int) result);
        } else if (num1 instanceof Double) {
            return (T) Double.valueOf(result);
        } else if (num1 instanceof Float) {
            return (T) Float.valueOf((float) result);
        } else if (num1 instanceof Long) {
            return (T) Long.valueOf((long) result);
        } else {
            throw new IllegalArgumentException("Unsupported number type");
        }
    }
}