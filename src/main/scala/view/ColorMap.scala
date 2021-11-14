package view

import java.awt.Color

object ColorMap {

  private val colorMap: Map[Int, Color] = Map(
    0 -> new Color(0, 51, 51),
    1 -> new Color(0, 102, 102),
    2 -> new Color(150, 150, 150),
    3 -> new Color(120, 120, 120),
    4 -> Color.gray,
    5 -> new Color(96, 96, 96),
    6 -> Color.darkGray,
    7 -> new Color(100, 10, 0),
    8 -> new Color(250, 150, 2),
    9 -> Color.yellow,
    10 -> new Color(18, 205, 20),
    11 -> new Color(200, 90, 0),
    12 -> new Color(250, 90, 0),
    13 -> new Color(192, 192, 192),
    14 -> new Color(150, 0, 100),
    15 -> new Color(180, 205, 20),
    16 -> new Color(180, 205, 20),
    17 -> new Color(180, 65, 20),
    18 -> new Color(180, 1, 20),
    19 -> new Color(60, 75, 20)
  )

  def getColor(iterations: Int): Color =
    val normalizedToRange = iterations / 5;
    colorMap.get(normalizedToRange).getOrElse(Color.white)

}
