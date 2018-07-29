package io.github.leeshangqian.hejin.instruments

import java.time.{LocalDateTime, ZonedDateTime, Month, ZoneId}

import cats.Id
import org.scalatest.{FlatSpec, Matchers}

import io.github.leeshangqian.hejin._
import io.github.leeshangqian.hejin.Contract._
import io.github.leeshangqian.hejin.instruments.Options._


class OptionsSuite extends FlatSpec with Matchers {
  "european option" should "be able to be valued" in {
    val date = ZonedDateTime.of(
      LocalDateTime.of(2018, Month.JANUARY, 20, 5, 30),
      ZoneId.of("Asia/Singapore")
    )

    val exercised = scale(konst[Id, Double](1))(one(SGD))

    val european = europeanOption(date, exercised)

    val (exercisedValue, zeroValue) = european match {
      case When(_, x) => x match {
        case Or(v, z) => (v, z)
        case _ => null
      }
      case _ => null
    }

    exercisedValue should be (scale(konst[Id, Double](1))(one(SGD)))
    zeroValue should be (zero)
  }
}
