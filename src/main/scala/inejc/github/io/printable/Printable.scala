package inejc.github.io.printable

// type class (definition of the API)
trait Printable[A] {

  def format(value: A): String
}

// type class instances (implementations for the types we care about)
object Printable {

  // implicit lazy val printableString: Printable[String] = new Printable[String] {
  //
  //  override def format(value: String): String = value
  // }

  // or shorter as a single abstract method expression
  implicit lazy val printableString: Printable[String] = (value: String) => value

  implicit lazy val printableInt: Printable[Int] = (value: Int) => value.toString
}

// the actual interface exposed to the user using extension methods
object PrintableSyntax {

  implicit class PrintableOps[A](value: A) {

    def formatToString(implicit p: Printable[A]): String = p.format(value)

    def print(implicit p: Printable[A]): Unit = println(p.format(value))
  }
}
