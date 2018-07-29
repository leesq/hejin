package io.github.leeshangqian.hejin.instruments

import java.time.ZonedDateTime

import io.github.leeshangqian.hejin.Contract
import io.github.leeshangqian.hejin.Contract._

object Options {
  def europeanOption(t: ZonedDateTime, u: Contract): Contract = when(at(t))(u or zero)
}
