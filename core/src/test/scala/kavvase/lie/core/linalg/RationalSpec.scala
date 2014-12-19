package kavvase.lie.core.linalg

import org.specs2.mutable.Specification

class RationalSpec extends Specification {

  "rational" should {

    import kavvase.lie.core.rational._
    import scala.math.Numeric.Implicits._

    "support addition" in {
      (1 over 4) + (1 over 4) mustEqual (1 over 2)
      (1 over 4) + (2 over 4) mustEqual (3 over 4)
      (1 over 4) + (-3 over -4) mustEqual 1.toRational
    }

    "support subtraction" in {
      1 - (1 over 4) mustEqual (3 over 4)
      1 - (2 over 4) mustEqual (1 over 2)
      1 - (-3 over -4) mustEqual (1 over 4)
    }

    "support multiplication" in {
      2 * (1 over 4) mustEqual (1 over 2)
      (-1 over 2) * (1 over -2) mustEqual (1 over 4)
      (2 over 3) * (-3 over 4) mustEqual (-1 over 2)
    }

    "support negation" in {
      - (1 over 4) mustEqual (-1 over 4)
      - (-1 over 4) mustEqual (1 over 4)
      - (1 over -4) mustEqual (1 over 4)
      - (-1 over -4) mustEqual (-1 over 4)
    }

    "support conversion to int" in {
      4.toRational.toInt mustEqual 4
      (4 over 2).toInt mustEqual 2
      (4 over 3).toInt mustEqual 1
      (4 over 4).toInt mustEqual 1
    }

    "support conversion to long" in {
      4.toRational.toLong mustEqual 4L
      (4 over 2).toLong mustEqual 2L
      (4 over 3).toLong mustEqual 1L
      (4 over 4).toLong mustEqual 1L
    }

    "support conversion to float" in {
      1.toRational.toFloat mustEqual 1.0
      (1 over 2).toFloat mustEqual 0.5
      (1 over 4).toFloat mustEqual 0.25
    }

    "support conversion to double" in {
      1.toRational.toDouble mustEqual 1.0
      (1 over 2).toDouble mustEqual 0.5
      (1 over 4).toDouble mustEqual 0.25
    }

  }

}
