package kavvase.lie.core

import kavvase.lie.core.linalg.ColVector

import scala.annotation.tailrec

case class Weight(
  labels: List[Int],
  steps: List[Int]
)

class WeightSystem[G <: Lie](g: G)(implicit algebra: LieAlgebra[G]) {

  import kavvase.lie.core.matrix._
  import kavvase.lie.core.vector._

  private val transposedCartan = algebra.cartan(g).transpose

  def highestWeight(labels: List[Int]): Weight = {
    Weight(labels, labels.map(_ => 0))
  }

  def weights(highest: Weight): Set[Weight] = {
    val stock = updateStock(highest.labels, Map.empty)
    loopWeights(Set((highest, stock)), highest, Set(highest))
  }

  @tailrec
  private def loopWeights(weights: Set[(Weight, Map[Int, Int])], highest: Weight, acc: Set[Weight]): Set[Weight] = {
    for {
      (weight, stock) <- weights
      next <- nextWeights(weight, stock, highest)
    } yield next
  } match {
    case ws if ws.nonEmpty => loopWeights(ws, highest, acc union ws.map(_._1))
    case _ => acc
  }

  private def nextWeights(weight: Weight, stock: Map[Int, Int], highest: Weight): Set[(Weight, Map[Int, Int])] = {
    for {
      (idx, count) <- stock.toSet
      if count > 0
      nextSteps = weight.steps.zipWithIndex.map { case (step, i) => if (i == idx) step + 1 else step }
      labels = dynkinLabels(nextSteps, highest)
      nextStock = updateStock(labels, stock.updated(idx, count - 1))
      nextWeight = Weight(labels, nextSteps)
    } yield (nextWeight, nextStock)
  }

  private def updateStock(labels: List[Int], stock: Map[Int, Int]): Map[Int, Int] = {
    for {
      (label, idx) <- labels.zipWithIndex
    } yield (idx, math.max(label, stock.getOrElse(idx, 0)))
  }.toMap

  def dynkinLabels(steps: List[Int], highest: Weight): List[Int] = {
    (ColVector(highest.labels) - transposedCartan * ColVector(steps)).components
  }

}
