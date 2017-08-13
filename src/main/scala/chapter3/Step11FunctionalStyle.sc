// less vars you have more functional your code is (kinda)

// it has var so not so functional
def printArgs1(args: Array[String]): Unit = {
  var i = 0
  while (i < args.length) {
    println(args(i))
    i += 1
  }
}

// that's better
def printArgs2(args: Array[String]): Unit = {
  for (arg <- args)
    println(arg)
}

// even better
def printArgs3(args: Array[String]): Unit = {
  args.foreach(println)
}

val args = Array("1", "2", "3")
printArgs1(args)
printArgs2(args)
printArgs3(args)

// well. Unit means side effects - not so functional again

// no side effects and no vars - the best!
def formatArgs(args: Array[String]) = args.mkString("\n")
println(formatArgs(args))

// it's easier to test
val res = formatArgs(args)
assert(res == "1\n2\n3")