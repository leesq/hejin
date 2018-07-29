package io.github.leeshangqian.hejin.instruments

import java.time.ZonedDateTime

import io.github.leeshangqian.hejin.Contract
import io.github.leeshangqian.hejin.Contract._
import io.github.leeshangqian.hejin.Currency

object Bonds {
  def zeroCouponBond(t: ZonedDateTime, x: Double, k: Currency): Contract =
    when(at(t))(scale(konst(x))(one(k)))
}
