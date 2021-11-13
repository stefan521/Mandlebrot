package logic

case class ComplexNumber(real: Double, imaginary: Double) {

  def modulus = Math.sqrt(real * real + imaginary * imaginary)

  def * (other: ComplexNumber): ComplexNumber = ComplexNumber(
    real * other.real - imaginary * other.imaginary,
    real * other.imaginary + imaginary * other.real
  )

  def + (other: ComplexNumber): ComplexNumber = ComplexNumber(
    real + other.real,
    imaginary + other.imaginary
  )

}