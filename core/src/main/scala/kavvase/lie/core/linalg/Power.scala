package kavvase.lie.core.linalg

import kavvase.lie.core.linalg.Power.{Base, Exponent}

import scalaz.Scalaz._
import scalaz.{Equal, Monoid}

case class Power(exponents: Map[Base, Exponent]) {

  def simplify: Power = Power.reduce(exponents)

}

object Power {

  import scala.math.Numeric.Implicits._

  type Base = Rational

  type Exponent = Rational

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