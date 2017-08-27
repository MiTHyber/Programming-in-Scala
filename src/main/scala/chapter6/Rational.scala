package chapter6


class Rational(n: Int, d: Int) {
//   Code inside of the class body that's not a field or method definition goes into the primary constructor
//   println("Created " + n + "/" + d)

//  It's a precondition
  require(d != 0)

//  to access class parameters of another Rational we make them into fields
  val numer: Int = n
  val denom: Int = d

  override def toString: String = numer + "/" + denom

  def add(that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
}

object Main extends App {
  println(new Rational(1, 2))
//  now it throws IllegalArgumentException
//  println(new Rational(5, 0))
  val oneHalf = new Rational(1, 2)
  val twoThirds = new Rational(2, 3)
  println(oneHalf add twoThirds)
  println(oneHalf.numer)
  println(oneHalf.denom)
}