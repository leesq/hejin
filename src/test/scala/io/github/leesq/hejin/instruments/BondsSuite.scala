package io.github.leesq.hejin.instruments

import java.time.{LocalDateTime, ZonedDateTime, Month, ZoneId}

import cats.Id
import org.scalatest.{FlatSpec, Matchers}

import io.github.leesq.hejin._
import io.github.leesq.hejin.Contract._
import io.github.leesq.hejin.instruments.Bonds._

class BondsSuite extends FlatSpec with Matchers {
  "zcb" should "be able to be valued" in {
    val date = ZonedDateTime.of(
      LocalDateTime.of(2018, Month.JANUARY, 20, 5, 30),
      ZoneId.of("Asia/Singapore")
    )

    val zcb = zeroCouponBond(date, 10 , TWD)

    val contractValue = zcb match {
      case When(_, x) => x
      case _ => null
    }

    contractValue should be (scale(konst[Id, Double](10))(one(TWD)))
  }
}
