package inejc.github.io.semigroup

trait SemiGroup[A] {

  def combine(x: A, y: A): A
}

trait Monoid[A] extends SemiGroup[A] {

  def empty: A
}

object Monoid {

  def apply[A](implicit m: Monoid[A]): Monoid[A] = m
}

object BooleanInstances {

  implicit lazy val andBooleanMonoid: Monoid[Boolean] = new Monoid[Boolean] {

    override def empty: Boolean = true

    override def combine(x: Boolean, y: Boolean): Boolean = x && y
  }

  implicit lazy val orBooleanMonoid: Monoid[Boolean] = new Monoid[Boolean] {

    override def empty: Boolean = false

    override def combine(x: Boolean, y: Boolean): Boolean = x || y
  }
}
