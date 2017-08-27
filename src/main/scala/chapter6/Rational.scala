package chapter6


class Rational(n: Int, d: Int) {
//   Code inside of the class body that's not a field or method definition goes into the primary constructor
//   println("Created " + n + "/" + d)

//  It's a precondition
  require(d != 0)

  private val g = gcd(n.abs, d.abs)
//  to access class parameters of another Rational we make them into fields
  val numer: Int = n / g
  val denom: Int = d / g

//  auxiliary constructor
  def this(n: Int) = this(n, 1)

  override def toString: String = numer + "/" + denom

  def + (that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def * (that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)

  def lessThan(that: Rational) = this.numer * that.denom < that.numer * this.denom

  def max(that: Rational) = if (this.lessThan(that)) that else this

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}

object Main extends App {
  println(new Rational(1, 2))
//  now it throws IllegalArgumentException
//  println(new Rational(5, 0))
  val oneHalf = new Rational(1, 2)
  val twoThirds = new Rational(2, 3)
  println(oneHalf + twoThirds)
  println(oneHalf.numer)
  println(oneHalf.denom)
  val y = new Rational(3)
  println(y)
  println(new Rational(66, 42))
  println(oneHalf + oneHalf * twoThirds)
  println((oneHalf + oneHalf) * twoThirds)
  println(oneHalf + (oneHalf * twoThirds))
}