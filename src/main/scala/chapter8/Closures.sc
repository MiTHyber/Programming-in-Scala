var more = 1

// closure [more is a free variable]
val addMore = (x: Int) => x + more

addMore(10) // 11

// closure sees the change [it captures variables, not values]
more = 9999
addMore(10) // 10009

//same is true in other direction
val someNumbers = List(-11, -10, -5, 0, 5, 10)
var sum = 0
someNumbers.foreach(sum += _)
sum // -11

// function that creates closures
def makeIncreaser(more: Int) = (x: Int) => x + more
val inc1 = makeIncreaser(1)
val inc9999 = makeIncreaser(9999)
inc1(10) // 11
inc9999(10) // 10009