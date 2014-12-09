package kavvase.lie.core.linalg

import org.specs2.mutable.Specification

class RationalSpec extends Specification {

  "rational" should {

    import scala.math.Numeric.Implicits._

    "support addition" in {
      Rational(1, 4) + Rational(1, 4) mustEqual Rational(1, 2)
      Rational(1, 4) + Rational(2, 4) mustEqual Rational(3, 4)
      Rational(1, 4) + Rational(-3, -4) mustEqual Rational(1, 1)
    }

    "support subtraction" in {
      Rational(1, 1) - Rational(1, 4) mustEqual Rational(3, 4)
      Rational(1, 1) - Rational(2, 4) mustEqual Rational(1, 2)
      Rational(1, 1) - Rational(-3, -4) mustEqual Rational(1, 4)
    }

    "support multiplication" in {
      Rational(1, 4) * Rational(2, 1) mustEqual Rational(1, 2)
      Rational(-1, 2) * Rational(1, -2) mustEqual Rational(1, 4)
      Rational(2, 3) * Rational(-3, 4) mustEqual Rational(-1, 2)
    }

    "support negation" in {
      - Rational(1, 4) mustEqual Rational(-1, 4)
      - Rational(-1, 4) mustEqual Rational(1, 4)
      - Rational(1, -4) mustEqual Rational(1, 4)
      - Rational(-1, -4) mustEqual Rational(-1, 4)
    }

    "support conversion to int" in {
      Rational(4, 1).toInt mustEqual 4
      Rational(4, 2).toInt mustEqual 2
      Rational(4, 3).toInt mustEqual 1
      Rational(4, 4).toInt mustEqual 1
    }

    "support conversion to long" in {
      Rational(4, 1).toLong mustEqual 4L
      Rational(4, 2).toLong mustEqual 2L
      Rational(4, 3).toLong mustEqual 1L
      Rational(4, 4).toLong mustEqual 1L
    }

    "support conversion to float" in {
      Rational(1, 1).toFloat mustEqual 1.0
      Rational(1, 2).toFloat mustEqual 0.5
      Rational(1, 4).toFloat mustEqual 0.25
    }

    "support conversion to double" in {
      Rational(1, 1).toDouble mustEqual 1.0
      Rational(1, 2).toDouble mustEqual 0.5
      Rational(1, 4).toDouble mustEqual 0.25
    }

  }

}
