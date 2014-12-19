package kavvase.lie.core.linalg

import scalaz.Order

case class Rational(numerator: Int, denominator: Int = 1) {

  require(denominator != 0)

  def simplify: Rational = Rational.reduce(numerator, denominator)

}

object Rational {

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }

  private def reduce(a: Int, b: Int): Rational = {
    val d = gcd(a, b)
    val num = a / d
    val den = b / d
    Rational(num * den.signum, den * den.signum)
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

  implicit def RationalOrder: Order[Rational] = Order.fromScalaOrdering

}

trait RationalSyntax {

  implicit class IntToRational(numerator: Int) {

    import scala.math.Numeric.Implicits._

    def toRational: Rational = Rational(numerator)

    def over(denominator: Int): Rational = Rational(numerator, denominator)

    def +(rational: Rational): Rational = numerator.toRational + rational

    def -(rational: Rational): Rational = numerator.toRational - rational

    def *(rational: Rational): Rational = numerator.toRational * rational

  }

}