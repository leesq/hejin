package xyz.leesq.hejin.instruments

import java.time.ZonedDateTime

import cats.effect.Sync
import xyz.leesq.hejin.Contract
import xyz.leesq.hejin.Contract._

object Options {
  def europeanOption[F[_]: Sync](t: ZonedDateTime, u: Contract): Contract =
    when(at(t))(u or zero)
}
