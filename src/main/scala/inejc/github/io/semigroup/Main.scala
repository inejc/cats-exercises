package inejc.github.io.semigroup

// import inejc.github.io.semigroup.BooleanInstances.andBooleanMonoid
import inejc.github.io.semigroup.BooleanInstances.orBooleanMonoid

object Main extends App {

  def associativeLaw[A](x: A, y: A, z: A)(implicit m: Monoid[A]): Boolean =
    m.combine(x, m.combine(y, z)) == m.combine(m.combine(x, y), z)

  def identityLaw[A](x: A)(implicit m: Monoid[A]): Boolean =
    (m.combine(x, m.empty) == x) && (m.combine(m.empty, x) == x)

  println(associativeLaw(false, false, false))
  println(associativeLaw(false, false, true))
  println(associativeLaw(false, true, false))
  println(associativeLaw(false, true, true))
  println(associativeLaw(true, false, false))
  println(associativeLaw(true, false, true))
  println(associativeLaw(true, true, false))
  println(associativeLaw(true, true, true))
  println(identityLaw(true))
  println(identityLaw(false))
}
