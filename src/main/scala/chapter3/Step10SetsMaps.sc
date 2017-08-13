import scala.collection.mutable
import scala.collection.immutable.HashSet

// immutable set by default
var jetSet = Set("Boeing", "Airbus")
// creates another set and reassigns var jetSet with this set
jetSet += "Lear"
println(jetSet.contains("Cessna"))

// you need to use import to create mutable set
val movieSet = mutable.Set("Hitch", "Poltergeist")
movieSet += "Shrek"
println(movieSet)

// you can choose the implementation you need by import as well
val hashSet = HashSet("Tomatoes", "Chilies")
println(hashSet + "Coriander")

val treasureMap = mutable.Map[Int, String]()
treasureMap += (1 -> "Go to island.")
treasureMap += (2 -> "Find big X on ground.")
treasureMap += (3 -> "Dig.")
println(treasureMap(2))

// again - immutable by default
val romanNumeral = Map(
  1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V"
)
println(romanNumeral(4))
