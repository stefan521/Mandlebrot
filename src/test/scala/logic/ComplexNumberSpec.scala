package logic

import org.scalactic.TolerantNumerics
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ComplexNumberSpec extends AnyFlatSpec with Matchers {

  it should "add ComplexNumber(0, 0) and ComplexNumber(0, 0)" in {
    val result = ComplexNumber(0, 0) + ComplexNumber(0, 0)

    result shouldBe ComplexNumber(0, 0)
  }

  it should "add ComplexNumber(0, 1) and ComplexNumber(0, 0)" in {
    val result = ComplexNumber(0, 1) + ComplexNumber(0, 0)

    result shouldBe ComplexNumber(0, 1)
  }

  it should "add ComplexNumber(0, 3) and ComplexNumber(-2, 0)" in {
    val result = ComplexNumber(0, 3) + ComplexNumber(-2, 0)

    result shouldBe ComplexNumber(-2, 3)
  }

}
