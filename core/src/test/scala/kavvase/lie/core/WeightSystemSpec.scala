package kavvase.lie.core

import org.specs2.mutable.Specification

class WeightSystemSpec extends Specification {

  "weight system" should {

    "calculate dynkin labels given highest weight and steps" in {
      val weightSystem = new WeightSystem(A(2))
      val highestWeight = Weight(labels = List(1, 1), level = 0, degree = 1)

      weightSystem.dynkinLabels(highestWeight, List(1, 0)) mustEqual List(-1, 2)
      weightSystem.dynkinLabels(highestWeight, List(0, 1)) mustEqual List(2, -1)
      weightSystem.dynkinLabels(highestWeight, List(1, 1)) mustEqual List(0, 0)
      weightSystem.dynkinLabels(highestWeight, List(2, 1)) mustEqual List(-2, 1)
      weightSystem.dynkinLabels(highestWeight, List(1, 2)) mustEqual List(1, -2)
      weightSystem.dynkinLabels(highestWeight, List(2, 2)) mustEqual List(-1, -1)
    }

  }

}
