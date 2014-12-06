package kavvase.lie.core

import kavvase.lie.core.linalg.Matrix
import org.specs2.mutable.Specification

class LieAlgebraSpec extends Specification {

  import kavvase.lie.core.lie._

  "a(n) algebra" should {

    val n = 4

    "have rank n" in {
      A(n).rank mustEqual n
    }

    "have su(n+1) cartan matrix" in {
      val cartan = Matrix(List(
        List( 2, -1,  0,  0),
        List(-1,  2, -1,  0),
        List( 0, -1,  2, -1),
        List( 0,  0, -1,  2)
      ))

      A(n).cartan mustEqual cartan
    }

  }

  "b(n) algebra" should {

    val n = 4

    "have rank n" in {
      B(n).rank mustEqual n
    }

    "have so(2n+1) cartan matrix" in {
      val cartan = Matrix(List(
        List( 2, -1,  0,  0),
        List(-1,  2, -1,  0),
        List( 0, -1,  2, -2),
        List( 0,  0, -1,  2)
      ))

      B(n).cartan mustEqual cartan
    }

  }

  "c(n) algebra" should {

    val n = 4

    "have rank n" in {
      C(n).rank mustEqual n
    }

    "have sp(n) cartan matrix" in {
      val cartan = Matrix(List(
        List( 2, -1,  0,  0),
        List(-1,  2, -1,  0),
        List( 0, -1,  2, -1),
        List( 0,  0, -2,  2)
      ))

      C(n).cartan mustEqual cartan
    }

  }

  "d(n) algebra" should {

    val n = 4

    "have rank n" in {
      D(n).rank mustEqual n
    }

    "have sp(n) cartan matrix" in {
      val cartan = Matrix(List(
        List( 2, -1,  0,  0),
        List(-1,  2, -1, -1),
        List( 0, -1,  2,  0),
        List( 0, -1,  0,  2)
      ))

      D(n).cartan mustEqual cartan
    }

  }

  "e6 algebra" should {

    "have rank 6" in {
      E6.rank mustEqual 6
    }

    "have e6 cartan matrix" in {
      val cartan = Matrix(List(
        List( 2, -1,  0,  0,  0,  0),
        List(-1,  2, -1,  0,  0,  0),
        List( 0, -1,  2, -1,  0, -1),
        List( 0,  0, -1,  2, -1,  0),
        List( 0,  0,  0, -1,  2,  0),
        List( 0,  0, -1,  0,  0,  2)
      ))

      E6.cartan mustEqual cartan
    }

  }

  "e7 algebra" should {

    "have rank 7" in {
      E7.rank mustEqual 7
    }

    "have e6 cartan matrix" in {
      val cartan = Matrix(List(
        List( 2, -1,  0,  0,  0,  0,  0),
        List(-1,  2, -1,  0,  0,  0,  0),
        List( 0, -1,  2, -1,  0,  0, -1),
        List( 0,  0, -1,  2, -1,  0,  0),
        List( 0,  0,  0, -1,  2, -1,  0),
        List( 0,  0,  0,  0, -1,  2,  0),
        List( 0,  0, -1,  0,  0,  0,  2)
      ))

      E7.cartan mustEqual cartan
    }

  }

  "e8 algebra" should {

    "have rank 8" in {
      E8.rank mustEqual 8
    }

    "have e8 cartan matrix" in {
      val cartan = Matrix(List(
        List( 2, -1,  0,  0,  0,  0,  0,  0),
        List(-1,  2, -1,  0,  0,  0,  0,  0),
        List( 0, -1,  2, -1,  0,  0,  0,  0),
        List( 0,  0, -1,  2, -1,  0,  0,  0),
        List( 0,  0,  0, -1,  2, -1,  0, -1),
        List( 0,  0,  0,  0, -1,  2, -1,  0),
        List( 0,  0,  0,  0,  0, -1,  2,  0),
        List( 0,  0,  0,  0, -1,  0,  0,  2)
      ))

      E8.cartan mustEqual cartan
    }

  }

  "f4 algebra" should {

    "have rank 4" in {
      F4.rank mustEqual 4
    }

    "have f4 cartan matrix" in {
      val cartan = Matrix(List(
        List( 2, -1,  0,  0),
        List(-1,  2, -2,  0),
        List( 0, -1,  2, -1),
        List( 0,  0, -1,  2)
      ))

      F4.cartan mustEqual cartan
    }

  }

  "g2 algebra" should {

    "have rank 2" in {
      G2.rank mustEqual 2
    }

    "have g2 cartan matrix" in {
      val cartan = Matrix(List(
        List( 2, -3),
        List(-1,  2)
      ))

      G2.cartan mustEqual cartan
    }

  }

}
