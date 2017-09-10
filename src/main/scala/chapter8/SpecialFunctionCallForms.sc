import java.io.PrintStream

// asteriks means vararg is coming (available only for the last parameters)
def echo(args: String*) = for (arg <- args) println(arg)
echo()
echo("one")
echo("hello","world!")

val arr = Array("What's", "up", "doc?")
// echo(arr) Scala can't handle this without a help
echo(arr: _*)

def speed(distance: Float, time: Float): Float = distance / time
speed(100, 10)
// named arguments
speed(distance = 100, time = 10)
// order doesn't matter
speed(time = 10, distance = 100)
// you can mix both positional and named arguments. positional argument come first in this case

// default parameter values
def printTime(out: PrintStream = Console.out) = out.println("time = " + System.currentTimeMillis())
printTime()
printTime(Console.err)

def prinTime2(out: PrintStream = Console.out, divisor: Int = 1) = out.println("time = " + System.currentTimeMillis() / divisor)
prinTime2()
prinTime2(out = Console.err)
prinTime2(divisor = 1000)