package logic

import logic.MandlebrotLogic.{Member, NotMember}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MandlebrotLogicSpec extends AnyFlatSpec with Matchers {

  it should "identify (-1, 1j) as not a member" in new MembershipTest {
    mandlebrot.mandlebrotMember(ComplexNumber(-1 , 1)) shouldBe NotMember(3)
  }

  it should "identify (-1, 0j) as a member" in new MembershipTest {
    mandlebrot.mandlebrotMember(ComplexNumber(-1 , 0)) shouldBe Member(50)
  }

  it should "identify (-0.5, 0.5j) as a member" in new MembershipTest {
    mandlebrot.mandlebrotMember(ComplexNumber(-0.5 , 0.5)) shouldBe Member(50)
  }

  it should "identify (-0.5, -1j) as not a member" in new MembershipTest {
    mandlebrot.mandlebrotMember(ComplexNumber(-0.5 , -1)) shouldBe NotMember(4)
  }

  trait MembershipTest {
    lazy val mandlebrot = new MandlebrotLogic(50)
  }
}
