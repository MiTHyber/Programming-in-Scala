package chapter4

import chapter4.ChecksumAccumulator.calculate

// app trait in action
object FallWinterSpringSummer extends App {
  for (season <- List("fall", "winter", "spring"))
    println(season + ": " + calculate(season))
}
