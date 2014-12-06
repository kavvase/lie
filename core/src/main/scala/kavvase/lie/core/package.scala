package kavvase.lie

import kavvase.lie.core.linalg.{VectorSyntax, MatrixSyntax}

package object core {

  object lie extends LieAlgebraSyntax

  object matrix extends MatrixSyntax

  object vector extends VectorSyntax

}
