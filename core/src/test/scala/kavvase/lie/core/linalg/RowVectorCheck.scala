package kavvase.lie.core.linalg

import org.scalacheck.Arbitrary
import org.specs2.scalaz.Spec

import scalaz.scalacheck.ScalazProperties.{functor, equal}

class RowVectorCheck extends Spec {

  implicit val arbitralyRowVector = Arbitrary {
    for {
      x <- Arbitrary.arbitrary[Int]
      y <- Arbitrary.arbitrary[Int]
    } yield RowVector(List(x, y))
  }

  checkAll(equal.laws[RowVector[Int]])
  checkAll(functor.laws[RowVector])

}
