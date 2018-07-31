package inejc.github.io.printable

import inejc.github.io.printable.PrintableSyntax._

final case class Cat1(name: String, age: Int, color: String)

object Cat1 {

  implicit lazy val printableCat: Printable[Cat1] = (cat: Cat1) =>
    s"${cat.name.formatToString} is a ${cat.age.formatToString} year-old ${cat.color.formatToString} cat."
}

object MainPrintable extends App {
  val cat = Cat1("Garfield", 6, "ginger and black")
  cat.print
}
