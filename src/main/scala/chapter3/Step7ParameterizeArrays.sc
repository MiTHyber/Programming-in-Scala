import java.math.BigInteger

val big = new BigInteger("12345")

// bad way to create and initialize scala array
val greetStrings = new Array[String](3)
//greetStrings(0) = "Hello"
// the same as previous one
greetStrings.update(0,"Hello")
greetStrings(1) = ", "
greetStrings(2) = "world!\n"

// to is a method
// (0).to(2)
for (i <- 0 to 2)
  // print(greetStrings(i))
  // it's the same as previous one
  print(greetStrings.apply(i))

// why would you do that?
// val greetStrings: Array[String] = new Array[String](3)

1 + 2
// it's how it is actually called
1.+(2)

// better way to initialize an array
val numNames = Array("zero", "one", "two")
// same as previous
val numNames2 = Array.apply("zero", "one", "two")