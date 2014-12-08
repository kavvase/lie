package kavvase.lie.core.linalg

case class Rational(numerator: Int, denominator: Int = 1)

object Rational {

  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }

  def reduce(a: Int, b: Int): Rational = {
    val d = gcd(a, b)
    Rational(a / d, b / d)
  }

  implicit object RationalNumeric extends Numeric[Rational] {

    def plus(x: Rational, y: Rational): Rational = {
      reduce(x.numerator * y.denominator + y.numerator * x.denominator, x.denominator * y.denominator)
    }

    def minus(x: Rational, y: Rational): Rational = {
      x + negate(y)
    }

    def times(x: Rational, y: Rational): Rational = {
      reduce(x.numerator * y.numerator, x.denominator * y.denominator)
    }

    def negate(x: Rational): Rational = {
      reduce(-x.numerator, x.denominator)
    }

    def fromInt(x: Int): Rational = {
      Rational(x)
    }

    def toInt(x: Rational): Int = {
      x.numerator / x.denominator
    }

    def toLong(x: Rational): Long = {
      (x.numerator / x.denominator).toLong
    }

    def toFloat(x: Rational): Float = {
      x.numerator.toFloat / x.denominator.toFloat
    }

    def toDouble(x: Rational): Double = {
      x.numerator.toDouble / x.denominator.toDouble
    }

    def compare(x: Rational, y: Rational): Int = {
      x.numerator * y.denominator compare y.numerator * x.denominator
    }

  }

}
