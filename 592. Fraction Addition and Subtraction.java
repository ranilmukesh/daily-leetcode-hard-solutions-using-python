class Fraction {
    int numerator;
    int denominator;

    public Fraction() {
        this(0, 1);
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void compute(Fraction other) {
        this.numerator = this.numerator * other.denominator + this.denominator * other.numerator;
        this.denominator = this.denominator * other.denominator;
    }

    public Fraction reduced() {
        int gcd = gcd(Math.abs(this.numerator), Math.abs(this.denominator));
        return new Fraction(this.numerator / gcd, this.denominator / gcd);
    }

    public static Fraction parse(String expression) {
        String[] parts = expression.split("/");
        int numerator = Integer.parseInt(parts[0]);
        int denominator = Integer.parseInt(parts[1]);
        return new Fraction(numerator, denominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

class Solution {
    public String fractionAddition(String expression) {
        Fraction result = new Fraction();

        StringBuilder parts = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if ((c == '+' || c == '-') && parts.length() > 0) {
                Fraction fraction = Fraction.parse(parts.toString());
                result.compute(fraction);
                parts.setLength(0);
            }
            parts.append(c);
        }

        if (parts.length() > 0) {
            Fraction fraction = Fraction.parse(parts.toString());
            result.compute(fraction);
        }

        return result.reduced().toString();
    }
}
