package kavvase.lie.core

abstract class Freudenthal[G <: Lie](implicit algebra: LieAlgebra[G]) {

  def multiplicity(weight: Weight[G]): Int = ???

}
