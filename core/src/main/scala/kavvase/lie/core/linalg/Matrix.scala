package kavvase.lie.core.linalg

import scalaz.{Functor, Monoid}

case class Matrix[A](rows: List[List[A]])

object Matrix {

  implicit object MatrixFunctor extends Functor[Matrix] {

    def map[A, B](fa: Matrix[A])(f: (A) => B): Matrix[B] = Matrix(fa.rows.map(_.map(f)))

  }

  implicit def MatrixMonoid[A](implicit numeric: Numeric[A]): Monoid[Matrix[A]] = new Monoid[Matrix[A]] {

    import scala.math.Numeric.Implicits._

    override def zero: Matrix[A] = Matrix(Nil)

    override def append(f1: Matrix[A], f2: => Matrix[A]): Matrix[A] = {
      require(f1.rows.map(_.length) == f2.rows.map(_.length), s"Size does not match between $f1 and $f2.")
      Matrix((f1.rows, f2.rows).zipped.map((x, y) => (x, y).zipped.map(_ + _)))
    }

  }

}
