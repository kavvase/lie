package kavvase.lie.core

trait LieAlgebra[G <: Lie] {

  def rank(g: G): Int

  def cartan(g: G): Matrix[Int]

}

object LieAlgebra {

  implicit object AnAlgebra extends LieAlgebra[A] {

    def rank(g: A): Int = g.n

    def cartan(g: A): Matrix[Int] = ???

  }

  implicit object BnAlgebra extends LieAlgebra[B] {

    def rank(g: B): Int = g.n

    def cartan(g: B): Matrix[Int] = ???

  }

  implicit object CnAlgebra extends LieAlgebra[C] {

    def rank(g: C): Int = g.n

    def cartan(g: C): Matrix[Int] = ???

  }

  implicit object DnAlgebra extends LieAlgebra[D] {

    def rank(g: D): Int = g.n

    def cartan(g: D): Matrix[Int] = ???

  }

  implicit object E6Algebra extends LieAlgebra[E6.type] {

    def rank(g: E6.type): Int = 6

    def cartan(g: E6.type): Matrix[Int] = ???

  }

  implicit object E7Algebra extends LieAlgebra[E7.type] {

    def rank(g: E7.type): Int = 7

    def cartan(g: E7.type): Matrix[Int] = ???

  }

  implicit object E8Algebra extends LieAlgebra[E8.type] {

    def rank(g: E8.type): Int = 8

    def cartan(g: E8.type): Matrix[Int] = ???

  }

  implicit object F4Algebra extends LieAlgebra[F4.type] {

    def rank(g: F4.type): Int = 4

    def cartan(g: F4.type): Matrix[Int] = ???

  }

  implicit object G2Algebra extends LieAlgebra[G2.type] {

    def rank(g: G2.type): Int = 2

    def cartan(g: G2.type): Matrix[Int] = ???

  }

}

trait LieAlgebraSyntax {

  implicit class LieAlgebraOps[G <: Lie](g: G)(implicit algebra: LieAlgebra[G]) {

    def rank: Int = algebra.rank(g)

    def cartan: Matrix[Int] = algebra.cartan(g)

  }

}
