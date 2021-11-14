package view

case class NiceImage(realStart: Double, realEnd: Double, imaginaryStart: Double, imaginaryEnd: Double)

object NiceImages {
  val classicMandlebrot = NiceImage(realStart = -2, realEnd = 1, imaginaryStart = -1, imaginaryEnd = 1)

  val zoomedOne = NiceImage(realStart = 0.25, realEnd = 0.5, imaginaryStart = 0.25, imaginaryEnd = 0.5)

  val zoomedTwo = NiceImage(realStart = 0.4, realEnd = 0.475, imaginaryStart = 0.375, imaginaryEnd = 0.4)
}
