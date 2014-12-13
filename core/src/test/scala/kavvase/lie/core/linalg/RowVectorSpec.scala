package kavvase.lie.core.linalg

import org.specs2.mutable.Specification

class RowVectorSpec extends Specification {

  "row vector" should {

    import kavvase.lie.core.vector._

    "support addition with row vector" in {
      val vector1 = RowVector(List(1, 2, 3))
      val vector2 = RowVector(List(2, 3, 4))
      val vector3 = RowVector(List(1))

      vector1 + vector2 mustEqual RowVector(List(3, 5, 7))
      vector1 + vector3 must throwA[IllegalArgumentException]
    }

    "support subtraction with row vector" in {
      val vector1 = RowVector(List(1, 2, 3))
      val vector2 = RowVector(List(2, 3, 4))
      val vector3 = RowVector(List(1))

      vector1 - vector2 mustEqual RowVector(List(-1, -1, -1))
      vector1 - vector3 must throwA[IllegalArgumentException]
    }

    "support multiplication with column vector" in {
      val vector1 = RowVector(List(1, 2, 3))
      val vector2 = ColVector(List(2, 3, 4))
      val vector3 = ColVector(List(1))

      vector1 * vector2 mustEqual 20
      vector1 * vector3 must throwA[IllegalArgumentException]
    }

    "support multiplication with matrix" in {
      val vector = RowVector(List(1, 2, 3))
      val matrix1 = Matrix(List(List(1, 2), List(3, 4), List(5, 6)))
      val matrix2 = Matrix(List(List(1)))

      vector * matrix1 mustEqual RowVector(List(22, 28))
      vector * matrix2 must throwA[IllegalArgumentException]
    }

    "support negation" in {
      val vector = RowVector(List(1, 2))

      - vector mustEqual RowVector(List(-1, -2))
    }

  }

}
