package kavvase.lie.core.linalg

import scalaz.{Equal, Functor}

sealed trait Vector[A] {
  val components: List[A]
}

case class RowVector[A](components: List[A]) extends Vector[A]

case class ColVector[A](components: List[A]) extends Vector[A]

object Vector {

  implicit def RowVectorEqual[A](implicit e: Numeric[A]): Equal[RowVector[A]] = new Equal[RowVector[A]] {

    def equal(a1: RowVector[A], a2: RowVector[A]): Boolean = a1.components == a2.components

  }

  implicit def ColVectorEqual[A](implicit e: Numeric[A]): Equal[ColVector[A]] = new Equal[ColVector[A]] {

    def equal(a1: ColVector[A], a2: ColVector[A]): Boolean = a1.components == a2.components

  }

  implicit object RowVectorFunctor extends Functor[RowVector] {

    def map[A, B](fa: RowVector[A])(f: (A) => B): RowVector[B] = RowVector(fa.components.map(f))

  }

  implicit object ColVectorFunctor extends Functor[ColVector] {

    def map[A, B](fa: ColVector[A])(f: (A) => B): ColVector[B] = ColVector(fa.components.map(f))

  }

}

trait VectorSyntax {

  implicit class RowVectorOps[A](lhs: RowVector[A])(implicit e: Numeric[A]) {

    import scala.math.Numeric.Implicits._

    def +(rhs: RowVector[A]): RowVector[A] = {
      require(lhs.components.length == rhs.components.length, s"Size does not match between $lhs and $rhs.")
      RowVector((lhs.components, rhs.components).zipped.map(_ + _))
    }

    def -(rhs: RowVector[A]): RowVector[A] = - rhs + lhs

    def *(rhs: ColVector[A]): A = {
      require(lhs.components.length == rhs.components.length, s"Size does not match between $lhs and $rhs.")
      (lhs.components, rhs.components).zipped.map(_ * _).sum
    }

    def unary_-() = RowVector(lhs.components.map(-_))

  }

  implicit class ColVectorOps[A](lhs: ColVector[A])(implicit e: Numeric[A]) {

    import scala.math.Numeric.Implicits._

    def +(rhs: ColVector[A]): ColVector[A] = {
      require(lhs.components.length == rhs.components.length, s"Size does not match between $lhs and $rhs.")
      ColVector((lhs.components, rhs.components).zipped.map(_ + _))
    }

    def -(rhs: ColVector[A]): ColVector[A] = - rhs + lhs

    def *(rhs: RowVector[A]): Matrix[A] = {
      Matrix(lhs.components.map(l => rhs.components.map(l * _)))
    }

    def unary_-() = ColVector(lhs.components.map(-_))

  }

}