package xyz.leesq.hejin.instruments

import java.time.ZonedDateTime

import xyz.leesq.hejin.{Contract, Currency}
import xyz.leesq.hejin.Contract._
import cats.effect.Sync

object Bonds {
  def zeroCouponBond[F[_]: Sync](t: ZonedDateTime, x: Double, k: Currency): Contract =
    when(at(t))(scale(konst(x))(one(k)))
}
