package kavvase.lie.core.linalg

import org.specs2.mutable.Specification

class ColVectorSpec extends Specification {

  "column vector" should {

    import kavvase.lie.core.vector._

    "support addition with column vector" in {
      val vector1 = ColVector(List(1, 2, 3))
      val vector2 = ColVector(List(2, 3, 4))
      val vector3 = ColVector(List(1))

      vector1 + vector2 mustEqual ColVector(List(3, 5, 7))
      vector1 + vector3 must throwA[IllegalArgumentException]
    }

    "support subtraction with column vector" in {
      val vector1 = ColVector(List(1, 2, 3))
      val vector2 = ColVector(List(2, 3, 4))
      val vector3 = ColVector(List(1))

      vector1 - vector2 mustEqual ColVector(List(-1, -1, -1))
      vector1 - vector3 must throwA[IllegalArgumentException]
    }

    "support multiplication with row vector" in {
      val vector1 = ColVector(List(1, 2, 3))
      val vector2 = RowVector(List(2, 3, 4))
      val vector3 = RowVector(List(1))

      vector1 * vector2 mustEqual Matrix(List(List(2, 3, 4), List(4, 6, 8), List(6, 9, 12)))
      vector1 * vector3 mustEqual Matrix(List(List(1), List(2), List(3)))
    }

    "support negation" in {
      val vector = ColVector(List(1, 2))

      - vector mustEqual ColVector(List(-1, -2))
    }

  }

}
