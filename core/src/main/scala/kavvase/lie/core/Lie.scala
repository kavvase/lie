package kavvase.lie.core

sealed trait Lie

case class A(n: Int) extends Lie { require(n >= 1) }

case class B(n: Int) extends Lie { require(n >= 3) }

case class C(n: Int) extends Lie { require(n >= 2) }

case class D(n: Int) extends Lie { require(n >= 4) }

case object E6 extends Lie

case object E7 extends Lie

case object E8 extends Lie

case object F4 extends Lie

case object G2 extends Lie