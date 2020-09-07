package xyz.leesq.hejin.instruments

import java.time.ZonedDateTime

import xyz.leesq.hejin._
import xyz.leesq.hejin.Contract._
import cats.effect.Sync

object Bond {
  def zeroCouponBond[F[_]: Sync, T: Numeric](t: ZonedDateTime, x: T, k: Currency): Contract =
    when(at(t))(scale(konst(x))(one(k)))
}
