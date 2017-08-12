val oneTwoThree = List(1, 2, 3)

val oneTwo = List(1, 2)
val threeFour = List(3, 4)

// ::: list concatenation
val oneTwoThreeFour = oneTwo ::: threeFour
println(oneTwo + " and " + threeFour + " were not mutated.")
println("Thus, " + oneTwoThreeFour + " is a new List.")

val twoThree = List(2, 3)
// :: prepends an element to the beginning of a list
val zeroTwoThree = 0 :: twoThree
println(zeroTwoThree)

// methods with names that ends in a colon invoke methods on right operand
// so 0 :: twoThree is actually twoThree.::(0)

// Nil is an empty list
// so we append 7 to empty list, then 6 to List(7) etc.
val fiveSixSeven = 5 :: 6 :: 7 :: Nil
println(fiveSixSeven)

// append is bad (time grows linearly) - better prepend :: and then reverse
// or using ListBuffer (mutable List) and then toList