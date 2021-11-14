package view

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import javax.imageio.stream.ImageOutputStream

object DrawPng {

  def draw(image: MandlebrotImage): Unit = {
    val file: File = new File("mandlebrot.png")
    val img: BufferedImage = new BufferedImage(image.width, image.height, BufferedImage.TYPE_INT_RGB)

    image.image.map {
      case (Point(x, y), color) => img.setRGB(x, y, color)
    }

    val os: ImageOutputStream = ImageIO.createImageOutputStream(file)
    ImageIO.write(img, "png", os)
  }

}