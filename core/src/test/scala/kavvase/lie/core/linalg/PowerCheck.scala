package kavvase.lie.core.linalg

import org.scalacheck.{Gen, Arbitrary}
import org.specs2.scalaz.Spec

import scalaz.scalacheck.ScalazProperties.{equal, monoid}

class PowerCheck extends Spec {

  implicit val arbitraryPower = Arbitrary {
    for {
      w <- Gen.choose(-1000, 1000)
      x <- Gen.choose(-1000, 1000) suchThat (_ != 0)
      y <- Gen.choose(-1000, 1000)
      z <- Gen.choose(-1000, 1000) suchThat (_ != 0)
    } yield Power(Map(Rational(w, x) -> Rational(y, z)))
  }

  checkAll(equal.laws[Power])
  checkAll(monoid.laws[Power])

}
