val name = "reader"
println(s"Hello, $name!")

s"The answer is ${6 * 7}."

// the raw string interpolator doesn't recognise escape sequences
println(raw"No\\\\escape!")

// the f string interpolator let's you format embedded expressions
f"${math.Pi}%.5f"

val pi = "Pi"
f"$pi is approximately ${math.Pi}%.8f."