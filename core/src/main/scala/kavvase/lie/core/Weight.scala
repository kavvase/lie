package kavvase.lie.core

import kavvase.lie.core.linalg.{Rational, RowVector}

case class Weight[G <: Lie](vector: RowVector[Rational])
