1 == 2
1 != 2
2 == 2

// == and != works for all objects
List(1, 2, 3) == List(1, 2, 3)
List(1, 2, 3) == List(4, 5, 6)

// it's possible to compare objects of different types
1 == 1.0
List(1, 2, 3) == "hello"

// you can even compare against null (things that can be null) with no exceptions
List(1, 2, 3) == null
null == List(1, 2, 3)

("he" + "llo") == "hello"

// so it's like the equals() method in java