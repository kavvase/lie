package kavvase.lie.core.linalg

import org.specs2.mutable.Specification

class PowerSpec extends Specification {

  "power" should {

    import kavvase.lie.core.rational._
    import kavvase.lie.core.power._

    "support multiplication" in {
      val x1 = (1 over 2)^(1 over 2)
      val x2 = (1 over 2)^(-1)
      val x3 = (3 over 2)^(1 over 4)

      x1 * x2 mustEqual (1 over 2)^(-1 over 2)
      x1 * x3 mustEqual Power(Map((1 over 2) -> (1 over 2), (3 over 2) -> (1 over 4)))
    }

    "be converted to double" in {
      val x1 = (1 over 4)^(1 over 2)
      val x2 = (1 over 2)^(-1)
      val x3 = Power(Map((1 over 4) -> (1 over 2), (1 over 2) -> (-1).toRational))

      x1.toDouble mustEqual 0.5
      x2.toDouble mustEqual 2.0
      x3.toDouble mustEqual 1.0
    }

  }

}
