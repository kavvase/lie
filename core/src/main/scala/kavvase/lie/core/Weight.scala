package kavvase.lie.core

case class Weight(
  dynkinIndex: List[Int],
  level: Int,
  degree: Int
)

abstract class WeightSystem[G <: Lie](implicit algebra: LieAlgebra[G]) {

  def weights(highestWeight: Weight): List[Weight] = ???

}
