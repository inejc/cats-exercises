package inejc.github.io.functor

import cats.Functor
import cats.syntax.functor._

sealed trait Tree[+A]

final case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

final case class Leaf[A](value: A) extends Tree[A]

object Tree {

  implicit lazy val treeFunctor: Functor[Tree] = new Functor[Tree] {

    override def map[A, B](fa: Tree[A])(f: A => B): Tree[B] = fa match {
        case Branch(left, right) => Branch(map(left)(f), map(right)(f))
        case Leaf(value) => Leaf(f(value))
    }
  }
}

object Main extends App {
  val t: Tree[Int] = Branch(Branch(Leaf(1), Leaf(3)), Leaf(4))
  println(t)
  println(t.map(_.toDouble + 1))
}
