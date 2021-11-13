import logic.{ComplexNumber, MandlebrotLogic}
import view.{DrawPng, MandlebrotImage}

object Main {

  def main(args: Array[String]): Unit = {
    val mandlebrot = new MandlebrotLogic(80)
    val r = List(-1, -0.5, 0, 0.5, 1);

    for {
      a <- r
      b <- r
      c = ComplexNumber(a, b)
    } println((c, mandlebrot.mandlebrotMember(c)))
  }

  DrawPng.draw(MandlebrotImage(100, 100, Map.empty))

}