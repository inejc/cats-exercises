package inejc.github.io.printable

import inejc.github.io.printable.PrintableSyntax._

final case class Cat(name: String, age: Int, color: String)

object Cat {

  implicit lazy val printableCat: Printable[Cat] = (cat: Cat) =>
    s"${cat.name.formatToString} is a ${cat.age.formatToString} year-old ${cat.color.formatToString} cat."
}

object Main extends App {
  val cat = Cat("Garfield", 6, "ginger and black")
  cat.print
}
