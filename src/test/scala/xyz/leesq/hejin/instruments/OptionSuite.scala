//package xyz.leesq.hejin.instruments
//
//import java.time.{LocalDateTime, Month, ZoneId, ZonedDateTime}
//
//import cats.effect.IO
//import org.scalatest.flatspec.AnyFlatSpec
//import org.scalatest.matchers.should
//import xyz.leesq.hejin._
//import xyz.leesq.hejin.Contract._
//import xyz.leesq.hejin.instruments.Option._
//
//class OptionSuite extends AnyFlatSpec with should.Matchers {
//  "european option" should "be able to be valued" in {
//    val date = ZonedDateTime.of(
//      LocalDateTime.of(2018, Month.JANUARY, 20, 5, 30),
//      ZoneId.of("Asia/Singapore")
//    )
//
//    val exercised = scale(konst[IO, BigDecimal](1))(one(SGD))
//
//    val european = europeanOption[IO](date, exercised)
//
//    val (exercisedValue: Contract, zeroValue: Contract) = european match {
//      case When(_, x) =>
//        x match {
//          case Or(v, z) => (v, z)
//          case _        => zero
//        }
//      case _ => zero
//    }
//
//    exercisedValue shouldBe scale(konst[IO, BigDecimal](1))(one(SGD))
//    zeroValue shouldBe zero
//  }
//}
