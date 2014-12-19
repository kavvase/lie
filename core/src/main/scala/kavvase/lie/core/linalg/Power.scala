package kavvase.lie.core.linalg

import kavvase.lie.core.linalg.Power.{Base, Exponent}

import scalaz.Scalaz._
import scalaz.{Equal, Monoid}

case class Power(exponents: Map[Base, Exponent]) {

  def simplify: Power = Power.reduce(exponents)

  def toDouble: Double = Power.toDouble(exponents)

}

object Power {

  import scala.math.Numeric.Implicits._

  type Base = Rational

  type Exponent = Rational

  private def toDouble(exponents: Map[Base, Exponent]): Double = {
    exponents.toList.foldLeft(1.0)((acc, a) => acc * math.pow(a._1.toDouble, a._2.toDouble))
  }

  private def reduce(exponents: Map[Base, Exponent]): Power = {
    Power({
      for {
        (base, exponent) <- exponents.toList
      } yield Map(base.simplify -> exponent.simplify)
    }.foldLeft(Map.empty[Base, Exponent])((a, b) => (a unionWith b)(_ + _)))
  }

  implicit object PowerEqual extends Equal[Power] {

    def equal(a1: Power, a2: Power): Boolean = a1.simplify.exponents == a2.simplify.exponents

  }

  implicit object PowerMonoid extends Monoid[Power] {

    def zero: Power = Power(Map.empty)

    def append(f1: Power, f2: => Power): Power = {
      Power((f1.exponents unionWith f2.exponents)(_ + _)).simplify
    }

  }

}

trait PowerSyntax {

  implicit class PowerOps(lhs: Power) {

    def *(rhs: Power): Power = lhs |+| rhs

  }

  implicit class RationalToPower(base: Rational) {

    import kavvase.lie.core.rational._

    def ^(exponent: Rational): Power = Power(Map(base -> exponent))

    def ^(exponent: Int): Power = Power(Map(base -> exponent.toRational))

  }

}