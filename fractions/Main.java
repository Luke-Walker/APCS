package fractions;

public class Main {

    public static void main(String[] args) {
        Fraction f1 = new Fraction(5,2);
        Fraction f2 = new Fraction(10,5);
        Fraction multiplied = Fraction.multiply(f1,f2);
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(multiplied);
    }
}
