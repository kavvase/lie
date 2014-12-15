package kavvase.lie.core

import kavvase.lie.core.linalg.ColVector

case class Weight(
  labels: List[Int],
  level: Int,
  degree: Int
)

class WeightSystem[G <: Lie](g: G)(implicit algebra: LieAlgebra[G]) {

  import kavvase.lie.core.vector._
  import kavvase.lie.core.matrix._

  val transposedCartan = algebra.cartan(g).transpose

  def weights(highestWeight: Weight): List[Weight] = ???

  def dynkinLabels(highestWeight: Weight, steps: List[Int]): List[Int] = {
    (ColVector(highestWeight.labels) - transposedCartan * ColVector(steps)).components
  }

  def multiplicity(labels: List[Int], highestWeight: Weight): Int = ???

}
