import logic.MandlebrotLogic.{Member, NotMember}
import logic.{ComplexNumber, MandlebrotLogic}
import view.{DrawPng, MandlebrotImage, NiceImages, Point}

import java.awt.Color

object Main {

  def main(args: Array[String]): Unit = drawMandlebrot()

  private def drawMandlebrot(width: Int = 3200, height: Int = 2500): Unit = {

    import collection.parallel.CollectionConverters._

    val mandlebrot = new MandlebrotLogic(100)

    val range = NiceImages.classicMandlebrot

    val points =
        for {
          x <- 0 until width
          y <- 0 until height
        } yield Point(x, y)

    val image =
      points.toList.par.map { point =>
          val real = range.realStart + (point.x.toDouble / width) * (range.realEnd - range.realStart)
          val imaginary = range.imaginaryStart + (point.y.toDouble / height) * (range.imaginaryEnd - range.imaginaryStart)
          val color = mandlebrot.mandlebrotMember(ComplexNumber(real, imaginary)) match {
            case NotMember(iterations) => Color.white.getRGB
            case Member(iterations) => Color.black.getRGB
          }
          point -> color
     }.toMap

    DrawPng.draw(MandlebrotImage(width, height, image))
  }

}