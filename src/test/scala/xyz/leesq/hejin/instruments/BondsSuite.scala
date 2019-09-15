package xyz.leesq.hejin.instruments

import java.time.{LocalDateTime, Month, ZoneId, ZonedDateTime}

import cats.effect.IO
import org.scalatest.{FlatSpec, Matchers}
import xyz.leesq.hejin._
import xyz.leesq.hejin.Contract._
import xyz.leesq.hejin.instruments.Bonds._

class BondsSuite extends FlatSpec with Matchers {
  "zcb" should "be able to be valued" in {
    val date = ZonedDateTime.of(
      LocalDateTime.of(2018, Month.JANUARY, 20, 5, 30),
      ZoneId.of("Asia/Singapore")
    )

    val zcb = zeroCouponBond[IO](date, 10, TWD)

    val contractValue = zcb match {
      case When(_, x) => x
      case _          => zero
    }

    contractValue should be(scale(konst[IO, Double](10))(one(TWD)))
  }
}
