package kavvase.lie.core.linalg

import org.scalacheck.Arbitrary
import org.specs2.scalaz.Spec

import scalaz.scalacheck.ScalazProperties.{equal, functor}

class MatrixCheck extends Spec {

  implicit val arbitralyMatrix = Arbitrary {
    for {
      w <- Arbitrary.arbitrary[Int]
      x <- Arbitrary.arbitrary[Int]
      y <- Arbitrary.arbitrary[Int]
      z <- Arbitrary.arbitrary[Int]
    } yield Matrix(List(List(w, x), List(y, z)))
  }

  checkAll(equal.laws[Matrix[Int]])
  checkAll(functor.laws[Matrix])

}
