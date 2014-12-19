package kavvase.lie

import kavvase.lie.core.linalg.{PowerSyntax, RationalSyntax, VectorSyntax, MatrixSyntax}

package object core {

  object lie extends LieAlgebraSyntax

  object matrix extends MatrixSyntax

  object vector extends VectorSyntax

  object rational extends RationalSyntax

  object power extends PowerSyntax

}
