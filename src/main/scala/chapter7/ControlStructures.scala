package chapter7

object ControlStructures extends App {
  //  imperative style (vars are detected)
  //  var filename = "default.txt"
  //  if (!args.isEmpty)
  //    filename = args(0)

  val filename =
    if (!args.isEmpty) args(0)
    else "default.txt"

}
