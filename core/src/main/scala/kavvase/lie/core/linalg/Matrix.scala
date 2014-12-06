package kavvase.lie.core.linalg

import scalaz.{Equal, Functor}

case class Matrix[A](rows: List[List[A]])

object Matrix {

  implicit def MatrixEqual[A](implicit e: Numeric[A]): Equal[Matrix[A]] = new Equal[Matrix[A]] {

    def equal(a1: Matrix[A], a2: Matrix[A]): Boolean = a1.rows == a2.rows

  }

  implicit object MatrixFunctor extends Functor[Matrix] {

    def map[A, B](fa: Matrix[A])(f: (A) => B): Matrix[B] = Matrix(fa.rows.map(_.map(f)))

  }

}

trait MatrixSyntax {

  implicit class MatrixOps[A](lhs: Matrix[A])(implicit e: Numeric[A]) {

    import scala.math.Numeric.Implicits._

    def +(rhs: Matrix[A]): Matrix[A] = {
      require(lhs.rows.map(_.length) == rhs.rows.map(_.length), s"Size does not match between $lhs and $rhs.")
      Matrix((lhs.rows, rhs.rows).zipped.map((l, r) => (l, r).zipped.map(_ + _)))
    }

    def -(rhs: Matrix[A]): Matrix[A] = - rhs + lhs

    def unary_-(): Matrix[A] = Matrix(lhs.rows.map(_.map(-_)))

  }

}