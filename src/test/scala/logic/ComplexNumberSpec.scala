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

  it should "multiply ComplexNumber(0, 0) and ComplexNumber(0, 0)" in {
    val result = ComplexNumber(0, 0) * ComplexNumber(0, 0)

    result shouldBe ComplexNumber(0, 0)
  }

  it should "multiply ComplexNumber(0, 1.5) and ComplexNumber(0, 60)" in {
    val result = ComplexNumber(0, 1.5) * ComplexNumber(0, 60)

    result shouldBe ComplexNumber(-90, 0)
  }

  it should "multiply ComplexNumber(2, 3) and ComplexNumber(-2, 0)" in {
    val result = ComplexNumber(2, 3) * ComplexNumber(-2, 0)

    result shouldBe ComplexNumber(-4, -6)
  }

  it should "calculate the modulus of ComplexNumber(2, 3)" in {
    doublesEqual(ComplexNumber(2, 3).modulus,  3.605)(tolerance = 0.001) shouldBe true
  }

  it should "calculate the modulus of ComplexNumber(21, 53)" in {
    doublesEqual(ComplexNumber(21, 53).modulus,  57.008)(tolerance = 0.001) shouldBe true
  }

  it should "calculate the modulus of ComplexNumber(-9, 3)" in {
    doublesEqual(ComplexNumber(-9, 3).modulus, 9.486)(tolerance = 0.001) shouldBe true
  }

  it should "calculate the modulus of ComplexNumber(1, 1)" in {
    doublesEqual(ComplexNumber(1, 1).modulus, 1.414)(tolerance = 0.001) shouldBe true
  }

  // ScalaTest has an implicit tolerance in Scala 2 but Scala 3 doesn't like it.
  private def doublesEqual(lhs: Double, rhs: Double)(tolerance: Double): Boolean =
    Math.abs(lhs - rhs) < tolerance

}
