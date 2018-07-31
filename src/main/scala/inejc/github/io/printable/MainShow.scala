package inejc.github.io.printable

import cats.Show
import cats.instances.int._
import cats.instances.string._
import cats.syntax.show._

final case class Cat2(name: String, age: Int, color: String)

object Cat2 {

  implicit lazy val catShow: Show[Cat2] =
    Show.show(cat => s"${cat.name.show} is a ${cat.age.show} year-old ${cat.color.show} cat.")
}

object MainShow extends App {
  val cat = Cat2("Garfield", 6, "ginger and black")
  println(cat.show)
}
