package chapter7

import java.io.{BufferedReader, File, FileNotFoundException, InputStreamReader}
import java.net.{MalformedURLException, URL}
import scala.util.control.Breaks._

import scala.io.{Source, StdIn}

object ControlStructures extends App {
  //  imperative style (vars are detected)
  //  var filename = "default.txt"
  //  if (!args.isEmpty)
  //    filename = args(0)

  val filename =
    if (!args.isEmpty) args(0)
    else "default.txt"

  // imperative style strikes again
  def gcdLoop(x: Long, y: Long): Long = {
    var a = x
    var b = y
    while (a != 0) {
      val temp = a
      a = b % a
      b = temp
    }
    b
  }

  //  functional alternative to gcd
  def gcd(x: Long, y: Long): Long =
    if (y == 0) x else gcd(y, x % y)

  //  var line = ""
  //  do {
  //    line = StdIn.readLine()
  //    println("Read: " + line)
  //  } while (line != "")

  //  () is the unit value - one value which type is Unit
  def greet() = {
    println("hi")
  }

  println(() == greet())

  //  assignment to var results in () so it's an infinite loop
  //  var line = ""
  //  while ((line = StdIn.readLine()) != "")
  //    println("Read: " + line)

  val filesHere = new File("./src/main/scala/chapter7").listFiles()

  for (file <- filesHere)
    println(file)

  for (i <- 1 to 4)
    println("Iteration " + i)

  //  it excludes upper bound of the range
  for (i <- 1 until 4)
    println("Iteration " + i)

  //  it's not cool
  //  for (i <- 0 to filesHere.length - 1)
  //    println(filesHere(i))

  //  filtering

  for (file <- filesHere if file.getName.endsWith(".scala"))
    println(file)

  //  no-no-no
  //  for (file <- filesHere)
  //    if (file.getName.endsWith(".scala"))
  //      println(file)

  //  multiple filters
  for (file <- filesHere
       if file.isFile
       if file.getName.endsWith(".scala")
  ) println(file)

  //  nested iterations
  def fileLines(file: java.io.File) =
    Source.fromFile(file).getLines().toList

  //  def grep(pattern: String) =
  //    for (
  //      file <- filesHere
  //      if file.getName.endsWith(".scala");
  //      line <- fileLines(file)
  //      if line.trim.matches(pattern)
  //    ) println(file + ": " + line.trim)

  //  mid-stream variable binding (doesn't work with brackets)
  def grep(pattern: String) =
    for {
      file <- filesHere
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      trimmed = line.trim
      if trimmed.matches(pattern)
    } println(file + ": " + trimmed)

  grep(".*gcd.*")

  //  for expression produces one value each time
  def scalaFiles =
    for {
      file <- filesHere
      if file.getName.endsWith(".scala")
    } yield file

  //  syntax error
  //  for (file <- filesHere if file.getName.endsWith(".scala")) {
  //    yield file
  //  }

  val forLineLength =
    for {
      file <- filesHere
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      trimmed = line.trim
      if trimmed.matches(".*for.*")
    } yield trimmed.length

  forLineLength.foreach(e => print(e + " "))
  println

  try {
    //    exception throw has type Nothing
    val n = 2
    val half =
      if (n % 2 == 0)
        n / 2
      else
        throw new RuntimeException("n must be even")
    throw new IllegalArgumentException("everything was fine but whatever")
  } catch {
    case ex: IllegalArgumentException => println(ex.getMessage)
    case ex: RuntimeException => ex.printStackTrace()
  } finally {
    println("I was here")
  }

  //  you can return values from catch
  def urlFor(path: String) =
    try {
      new URL(path)
    } catch {
      case e: MalformedURLException =>
        new URL("http://www.scala-lang.org")
    }

  val firstArg = if (args.length > 0) args(0) else ""

  val friend =
    firstArg match {
      case "salt" => "pepper"
      case "chips" => "salsa"
      case "eggs" => "bacon"
      case _ => "huh?"
    }
  println(friend)

  // no break or continue in scala

  //  This is Java
  //  int i = 0;
  //  boolean foundIt = false;
  //  while (i < args.length) {
  //    if (args[i].startsWith("-")) {
  //      i = i + 1;
  //      continue;
  //    }
  //    if (args[i].endsWith(".scala")) {
  //      foundIt = true;
  //      break;
  //    }
  //    i = i + 1;
  //  }

  //  Lame scala
  var i = 0
  var foundIt = false
  while (i < args.length && !foundIt) {
    if (!args(i).startsWith("-")) {
      if (args(i).endsWith(".scala"))
        foundIt = true
    }
    i = i + 1
  }

  //  Cool scala
  def searchFrom(i: Int): Int =
    if (i >= args.length) -1
    else if (args(i).startsWith("-")) searchFrom(i + 1)
    else if (args(i).endsWith(".scala")) i
    else searchFrom(i + 1)

  val j = searchFrom(0)

  //  helper in the standart library
  //  break breaks from breakable block
  //  call to break can be in another method
  val in = new BufferedReader(new InputStreamReader(System.in))
  breakable {
    while (true) {
      println("? ")
      if (in.readLine() == "") break
    }
  }
}
