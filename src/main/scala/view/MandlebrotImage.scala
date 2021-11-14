package view

import java.awt.Color
import scala.collection.parallel.immutable.ParMap

case class MandlebrotImage(width: Int, height: Int, image: ParMap[Point, Int])
