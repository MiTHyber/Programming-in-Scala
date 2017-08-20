val hex = 0x5
val hex2 = 0x00FF
val magic = 0xcafebabe

val dec1 = 31
val dec2 = 255
val dec3 = 20

val prog = 0XCAFEBABEL
val tower = 35L
val of = 31l

var little: Short = 367
val littler: Byte = 38

val big = 1.2345
val bigger = 1.2345e1
val biggerStill = 123E45

val little2 = 1.2345F
val littleBigger = 3e5f

val anotherDouble = 3e5
val yetAnother = 3e5D

val a = 'A'
val d = '\u0041'
val f = '\u0044'

// it doesn't work inside of intellij idea
// val B\u0041\u0044 = 1

val backslash = '\\'

val hello = "hello"
val escapes = "\\\"\'"

// """ is for raw strings
println(
  """Welcome to Ultamix 3000
    |Type "HELP" for help.
  """.stripMargin)

def updateRecordByName(r: Symbol, valie: Any) = {
  // code goes here
}

// the way you would use it in a dynamically typed language
// updateRecordByName(favoriteAlbum, "OK Computer")

// scala way
updateRecordByName('favoriteAlbum, "OK Computer")

val s = 'aSymbol
val nm = s.name

val bool = true
val fool = false