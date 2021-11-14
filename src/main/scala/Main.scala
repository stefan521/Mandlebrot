import logic.MandlebrotLogic.{Member, NotMember}
import logic.{ComplexNumber, MandlebrotLogic}
import view.{DrawPng, MandlebrotImage, NiceImages, Point, ColorMap}

import scala.collection.parallel.immutable.ParMap

import java.awt.Color

object Main {

  def main(args: Array[String]): Unit = drawMandlebrot()

  private def drawMandlebrot(width: Int = 3000, height: Int =2500): Unit = {

    import collection.parallel.CollectionConverters._

    val mandlebrot = new MandlebrotLogic(100)

    val range = NiceImages.classicMandlebrot

    val points =
        for {
          x <- 0 until width
          y <- 0 until height
        } yield Point(x, y)

    val image: ParMap[Point, Color]  =
      points.toList.par.map { point =>
          val real = range.realStart + (point.x.toDouble / width) * (range.realEnd - range.realStart)
          val imaginary = range.imaginaryStart + (point.y.toDouble / height) * (range.imaginaryEnd - range.imaginaryStart)
          val color = mandlebrot.mandlebrotMember(ComplexNumber(real, imaginary)) match {
            case NotMember(iterations) => ColorMap.getColor(iterations)
            case Member(_) => Color.black
          }
          point -> color
     }.toMap

    DrawPng.draw(MandlebrotImage(width, height, image))
  }

}