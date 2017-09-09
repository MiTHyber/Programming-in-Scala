// function literals
var increase = (x: Int) => x + 1

increase(10)

increase = (x: Int) => x + 9999

increase(10)

increase = (x: Int) => {
  println("We")
  println("Are")
  println("Here")
  x + 1
}

increase(10)

val someNumbers = List(-11, -10, -5, 0, 5, 10)

someNumbers.foreach((x: Int) => println(x))

someNumbers.filter(x => x > 0)

// _ placeholder, _ is filled with values of the list in this case
someNumbers.filter(_ > 0)

// first underscore is the first parameter, second - second and so on
val f = (_: Int) + (_: Int)

f(5, 10)

someNumbers.foreach(println)

def sum(a: Int, b: Int, c: Int) = a + b + c
sum(1, 2, 3)

// partially applied function
// we supplied none of the parameters
val a = sum _
a(1, 2, 3)
a.apply(1, 2, 3)

// you can transform def to a function value using x = function _ syntax

// you can supply only some of the arguments
val b = sum(1, _: Int, 3)
b(2)
b(5)