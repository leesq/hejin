package io.github.leesq.hejin.instruments

import java.time.ZonedDateTime

import io.github.leesq.hejin.Contract
import io.github.leesq.hejin.Contract._
import io.github.leesq.hejin.Currency

object Bonds {
  def zeroCouponBond(t: ZonedDateTime, x: Double, k: Currency): Contract =
    when(at(t))(scale(konst(x))(one(k)))
}
