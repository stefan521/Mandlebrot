package logic

import MandlebrotLogic._

class MandlebrotLogic(val maxIterations: Int) {

  def escapesToInfinity(number: ComplexNumber): Boolean = number.modulus > 2;

  def mandlebrotMember(number: ComplexNumber): MandlebrotMembership = {
    var z = ComplexNumber(0, 0);
    var n = 0;

    while (!escapesToInfinity(z) && n < maxIterations) {
      z = z * z + number
      n += 1
    }

    NotMember(n)
  }

}

object MandlebrotLogic {

  sealed trait MandlebrotMembership

  case object Member extends MandlebrotMembership

  /**
   *
   * @param iterations Number of steps required to determine a number is not part of the set.
   */
  case class NotMember(iterations: Int) extends MandlebrotMembership

}