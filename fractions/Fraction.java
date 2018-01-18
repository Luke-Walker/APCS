package fractions;

public class Fraction {

    public static Fraction multiply(Fraction f1, Fraction f2) {
        return new Fraction(f1.getNumerator()*f2.getNumerator(), f1.getDenominator()*f2.getDenominator());
    }

    private int n, d;

    public Fraction(int n, int d) {
        this.n = n;
        this.d = d;
    }

    public int getNumerator() {
        return n;
    }

    public int getDenominator() {
        return d;
    }

    @Override
    public String toString() {
        return n+"/"+d;
    }
}
