package kavvase.lie.core

import org.specs2.mutable.Specification

class WeightSystemSpec extends Specification {

  "weight system" should {

    "calculate weights from highest weight" in {
      val weightSystem = new WeightSystem(A(2))
      val highestWeight = weightSystem.highestWeight(List(1, 1))

      weightSystem.weights(highestWeight) mustEqual Set(
        Weight(labels = List(1, 1), steps = List(0, 0)),
        Weight(labels = List(-1, 2), steps = List(1, 0)),
        Weight(labels = List(2, -1), steps = List(0, 1)),
        Weight(labels = List(0, 0), steps = List(1, 1)),
        Weight(labels = List(0, 0), steps = List(1, 1)),
        Weight(labels = List(-2, 1), steps = List(2, 1)),
        Weight(labels = List(1, -2), steps = List(1, 2)),
        Weight(labels = List(-1, -1), steps = List(2, 2))
      )
    }

    "calculate dynkin labels given highest weight and steps" in {
      val weightSystem = new WeightSystem(A(2))
      val highestWeight = weightSystem.highestWeight(List(1, 1))

      weightSystem.dynkinLabels(List(1, 0), highestWeight) mustEqual List(-1, 2)
      weightSystem.dynkinLabels(List(0, 1), highestWeight) mustEqual List(2, -1)
      weightSystem.dynkinLabels(List(1, 1), highestWeight) mustEqual List(0, 0)
      weightSystem.dynkinLabels(List(2, 1), highestWeight) mustEqual List(-2, 1)
      weightSystem.dynkinLabels(List(1, 2), highestWeight) mustEqual List(1, -2)
      weightSystem.dynkinLabels(List(2, 2), highestWeight) mustEqual List(-1, -1)
    }

  }

}
