/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorjunit;

/**
 *
 * @author Admin
 */
public class CalculatorJUnit {

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
