package kavvase.lie.core.linalg

import scalaz.{Equal, Functor}

case class Matrix[A](rows: List[List[A]]) {

  require(rows.map(_.length).distinct.size == 1, s"Every row should have same size. $rows")

  val numRow = rows.length

  require(numRow > 0, s"Number of rows should be larger than 0. $rows")

  val numCol = rows.head.length


  def transpose: Matrix[A] = Matrix(transposeRows(rows))

  private def transposeRows(rows: List[List[A]]): List[List[A]] = {
    rows match {
      case Nil :: _ => Nil
      case _        => rows.map(_.head) :: transposeRows(rows.map(_.tail))
    }
  }

}

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
    import kavvase.lie.core.vector._

    def +(rhs: Matrix[A]): Matrix[A] = {
      require(lhs.numRow == rhs.numRow && lhs.numCol == rhs.numCol, s"Size does not match between $lhs and $rhs.")
      Matrix((lhs.rows, rhs.rows).zipped.map((l, r) => (l, r).zipped.map(_ + _)))
    }

    def -(rhs: Matrix[A]): Matrix[A] = - rhs + lhs

    def *(rhs: Matrix[A]): Matrix[A] = {
      require(lhs.numRow == rhs.numCol && lhs.numCol == rhs.numRow, s"Size does not match between $lhs and $rhs.")
      Matrix(lhs.rows.map(row => (RowVector(row) * rhs).components))
    }

    def *(rhs: ColVector[A]): ColVector[A] = {
      require(lhs.numCol == rhs.numRow, s"Size does not match between $lhs and $rhs.")
      ColVector(lhs.rows.map(row => (row, rhs.components).zipped.map(_ * _).sum))
    }

    def unary_-(): Matrix[A] = Matrix(lhs.rows.map(_.map(-_)))

  }

}