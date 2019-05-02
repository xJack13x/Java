package calculatorjunit;

/**
 *
 * @author Jacek
 */
public class IntegerNumber {

    public int addNumber(int a, int b){
        return a+b;
    }

    public int subtractNumber (int a, int b){
        return a-b;
    }

    public int multiplyNumber (int a, int b){
        return a*b;
    }

    public static int divideNumber(int a, int b){
        if (b == 0) {
            throw new IllegalArgumentException("Niedozwolone dzielenie przez 0");
        }
        return a/b;
    }

    public static long factorialNumber(int number) {
        int result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }

        if (number<0) {
            throw new IllegalArgumentException("Niedozwolony parametr mniejszy od 0");
        }
        System.out.println("wynik silni =" + result);
        return result;
    }

    public static void main(String[] Args) {
        }
}
