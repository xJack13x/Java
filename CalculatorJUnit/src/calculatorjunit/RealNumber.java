package calculatorjunit;

/**
 *
 * @author Jacek
 */
public class RealNumber {
    public double addRealNumber(double a, double b){
        return (a+b);
    }

    public double subtractRealNumber(double a, double b){
        return (a-b);
    }

    public double multiplyRealNumber(double a, double b){
        return (a*b);
    }

    public static double divideRealNumber(double a, double b){
        if (b == 0.0) {
            throw new IllegalArgumentException("Niedozwolone dzielenie przez 0");
        }
        return a/b;
    }

    public double squareRealNumber( double a){

        if (a < 0) {
            throw new IllegalArgumentException("Liczba pierwiastkowana 'a' nie moze być ujemna");
        }

        return (Math.sqrt(a));
    }

    public double powerRealNumber(double base, double power){
        return (Math.pow(base, power));
    }

    public static void main(String[] Args) {
    }
}
