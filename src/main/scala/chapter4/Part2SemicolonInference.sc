// you need a semicolon here. but why would you write code like that?
val s = "hello"; println(s)

val x = 1
if (x < 2)
  println("too small")
else
  println("ok")

val y = 2

// scala sees it as two expressions
x
+ y

// so you should put parentheses
(x
  + y)

val z = 3
// or put + symbol at the end of a line
x +
y +
z