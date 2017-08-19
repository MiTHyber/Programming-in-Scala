// default access level in scala is public (not package private like in java)

class ChecksumAccumulator {
  private var sum = 0

  def add(b: Byte): Unit = {
    // params in scala are vals
    // b = 1
    sum += b
  }

  def checksum(): Int = {
    return ~(sum & 0xFF) + 1
  }
}

val acc = new ChecksumAccumulator
val csa = new ChecksumAccumulator

// you can't access private from here just like in java
// acc.sum = 3

// val is final
// acc = new ChecksumAccumulator

// you can go for a maximum conciseness
class ConciseChecksumAccumulator {
  private var sum = 0
  def add(b: Byte) = sum += b
  def checksum() = ~(sum & 0xFF) + 1
}

// but it's better to have a readable code
class CoolChecksumAccumulator {
  private var sum = 0
  def add(b: Byte): Unit = { sum += b }
  def checksum(): Int = ~(sum & 0xFF) + 1
}