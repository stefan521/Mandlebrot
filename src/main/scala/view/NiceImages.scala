package view

case class NiceImage(realStart: Double, realEnd: Double, imaginaryStart: Double, imaginaryEnd: Double)

object NiceImages {
  val classicMandlebrot = NiceImage(realStart = -2, realEnd = 1, imaginaryStart = -1.2, imaginaryEnd = 1.2)

  val zoomed = NiceImage(realStart = 0.25, realEnd = 0.5, imaginaryStart = 0.25, imaginaryEnd = 0.5)
}
