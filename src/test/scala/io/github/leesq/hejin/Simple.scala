package io.github.leesq.hejin

import org.scalatest._
import io.github.leesq.hejin.Contract._

class Simple extends FlatSpec with Matchers {
  "A simple contract" should "can be implemented by the DSL" in {
    val simpleContract: Contract = one(TWD)
    simpleContract should be (one(TWD))
  }
}
