package kavvase.lie.core.linalg

import org.specs2.mutable.Specification

class MatrixSpec extends Specification {

  "matrix" should {

    import kavvase.lie.core.matrix._

    "support addition with matrix" in {
      val matrix1 = Matrix(List(List(1, 2, 3), List(4, 5, 6)))
      val matrix2 = Matrix(List(List(2, 3, 4), List(5, 6, 7)))
      val matrix3 = Matrix(List(List(1)))

      matrix1 + matrix2 mustEqual Matrix(List(List(3, 5, 7), List(9, 11, 13)))
      matrix1 + matrix3 must throwA[IllegalArgumentException]
    }

    "support subtraction with matrix" in {
      val matrix1 = Matrix(List(List(1, 2, 3), List(4, 5, 6)))
      val matrix2 = Matrix(List(List(2, 3, 4), List(5, 6, 7)))
      val matrix3 = Matrix(List(List(1)))

      matrix1 - matrix2 mustEqual Matrix(List(List(-1, -1, -1), List(-1, -1, -1)))
      matrix1 - matrix3 must throwA[IllegalArgumentException]
    }

    "support negation" in {
      val matrix = Matrix(List(List(1, 2), List(3, 4)))

      - matrix mustEqual Matrix(List(List(-1, -2), List(-3, -4)))
    }

  }

}
