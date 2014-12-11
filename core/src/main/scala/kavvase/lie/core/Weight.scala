package kavvase.lie.core

case class Weight(dynkinIndex: List[Int])

abstract class Freudenthal[G <: Lie](implicit algebra: LieAlgebra[G]) {

  def multiplicity(weight: Weight): Int = ???

}
