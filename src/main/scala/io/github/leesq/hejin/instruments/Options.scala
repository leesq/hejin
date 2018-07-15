package io.github.leesq.hejin.instruments

import java.time.ZonedDateTime

import io.github.leesq.hejin.Contract
import io.github.leesq.hejin.Contract._

object Options {
  def europeanOption(t: ZonedDateTime, u: Contract): Contract = when(at(t))(u or zero)
}
