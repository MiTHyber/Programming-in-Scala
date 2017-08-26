(2 + 2) * 7

(2 << 2 + 2) == (2 << (2 + 2))
(2 + 2 << 2) == (4 << 2)

var x1 = 1
var x2 = 1
val y = 2
x1 *= y + 1
x2 *= (y + 1)
x1 == x2

val a = 1
val b = 2
a * b == a.*(b)
// a ::: b == b.:::a
// more precisely a ::: b == { val x = a; b.:::(x) }

// a ::: b ::: c == a ::: (b ::: c)
// a * b * c == (a * b) * c