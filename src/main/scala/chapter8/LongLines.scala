package chapter8

import scala.io.Source

object LongLines {
  def processFile(filename: String, width: Int) = {

    // local functions can access the parameters of their enclosing functions
    def processLine(line: String) = {
      if (line.length > width)
        println(filename + ": " + line.trim)
    }

    val source = Source.fromFile(filename)
    for (line <- source.getLines())
      processLine(line)
  }

}
