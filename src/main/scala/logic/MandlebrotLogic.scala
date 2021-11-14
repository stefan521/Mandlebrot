package logic

import MandlebrotLogic.*

import scala.annotation.tailrec

class MandlebrotLogic(val maxIterations: Int) {

  def mandlebrotMember(numberToTest: ComplexNumber): MandlebrotMembership =
    mandlebrotMemberLogic(numberToTest)(ComplexNumber(0, 0), 0)

  @tailrec
  private def mandlebrotMemberLogic(numberToTest: ComplexNumber)(numberInSequence: ComplexNumber, currentIterations: Int): MandlebrotMembership = {

    if (escapesToInfinity(numberInSequence))
      NotMember(currentIterations)
    else if (currentIterations >= maxIterations)
      Member(currentIterations)
    else
      mandlebrotMemberLogic(numberToTest)(nextInMandlebrotSequence(numberToTest, numberInSequence), currentIterations + 1)
  }

  private def escapesToInfinity(number: ComplexNumber): Boolean = number.modulus > 2;

  private def nextInMandlebrotSequence(startingNumber: ComplexNumber, currentNumber: ComplexNumber) =
    currentNumber * currentNumber + startingNumber

}

object MandlebrotLogic {

  sealed trait MandlebrotMembership

  case class Member(iterations: Int) extends MandlebrotMembership

  /**
   *
   * @param iterations Number of steps required to determine a number is not part of the set.
   */
  case class NotMember(iterations: Int) extends MandlebrotMembership

}