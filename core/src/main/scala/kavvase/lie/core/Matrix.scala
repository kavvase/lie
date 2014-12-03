package kavvase.lie.core

import scalaz.Functor

case class Matrix[A](rows: List[List[A]])

object Matrix {

  implicit object MatrixFunctor extends Functor[Matrix] {

    def map[A, B](fa: Matrix[A])(f: (A) => B): Matrix[B] = Matrix(fa.rows.map(_.map(f)))

  }

}
