package kavvase.lie.core.linalg

import org.scalacheck.Arbitrary
import org.specs2.scalaz.Spec

import scalaz.scalacheck.ScalazProperties.{equal, functor}

class ColVectorCheck extends Spec {

  implicit val arbitraryColVector = Arbitrary {
    for {
      x <- Arbitrary.arbitrary[Int]
      y <- Arbitrary.arbitrary[Int]
    } yield ColVector(List(x, y))
  }

  checkAll(equal.laws[ColVector[Int]])
  checkAll(functor.laws[ColVector])

}
