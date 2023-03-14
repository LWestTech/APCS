/**
 * Represents a fraction
 **/
public class Fraction implements Comparable<Fraction>
{
  private int numerator;
  private int denominator;

  /**
  * Constructs a fraction
  **/
  public Fraction(int numerator, int denominator)
  {
    this.numerator = numerator;
    this.denominator = denominator;
  }

  /**
  * Returns the numerator
  * @return int numerator
  **/
  public int getNumerator()
  {
    return this.numerator;
  }

  /**
  * Returns the denominator
  * @return int denominator
  **/
  public int getDenominator()
  {
    return this.denominator;
  }

  /**
  * Returns the fraction in decimal form
  * @return double decimal
  **/
  public double getDecimalForm()
  {
    return this.getNumerator() / this.getDenominator();
  }

  /**
  * Returns the greatest common denominator of two integer numbers
  * @param one integer
  * @param another integer
  * @return int greatest common denominator
  **/
  private static int GCD(int a, int b)
  {
    return b == 0 ? a : GCD(b, a % b);
  }

  /**
  * Simplifies the fraction
  **/
  public void reduce()
  {
    int gcd = GCD(numerator,denominator);
    numerator = numerator / gcd;
    denominator = denominator / gcd;
  }

  /**
  * Compairs this fraction to a number in terms of difference in whole numbers
  * @param a fraction object
  * @return int difference
  **/
  public int compareTo(Fraction fraction)
  {
    
    return (int)(this.getDecimalForm() - fraction.getDecimalForm());
  }

  /**
  * Checks if two fractions represent the same number
  * @param a fraction object
  * @return true or false
  **/
  public boolean equals(Fraction fraction)
  {
    return this.getDecimalForm() == fraction.getDecimalForm();
  }

  /**
  * Converts the fraction into a string
  * @return the fraction in string form
  **/
  public String toString() {
    return "" + this.getNumerator() + "/" + this.getDenominator();
  }
}