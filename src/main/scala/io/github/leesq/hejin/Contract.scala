package io.github.leesq.hejin

import cats.Monad

sealed trait Contract

case object Zero extends Contract
case class One    (k: Currency) extends Contract
case class Give   (c: Contract) extends Contract
case class And    (c1: Contract)(c2: Contract) extends Contract
case class Or     (c1: Contract)(c2: Contract) extends Contract
case class Cond   [O[_]: Monad](b: O[Boolean])(c1: Contract)(c2: Contract) extends Contract
case class Scale  [O[_]: Monad](o: O[Double])(c: Contract) extends Contract
case class When   [O[_]: Monad](o: O[Boolean])(c: Contract) extends Contract
case class Anytime[O[_]: Monad](o: O[Boolean])(c: Contract) extends Contract
case class Until  [O[_]: Monad](o: O[Boolean])(c: Contract) extends Contract

object Contract {
  implicit class ContractOps(c1: Contract) {
    def and(c2: Contract): Contract = And(c1)(c2)
    def or (c2: Contract): Contract = Or(c1)(c2)
  }

  def one    : Currency => One = One.apply
  def give   : Contract => Contract = Give.apply
  def and    : Contract => Contract => Contract = And.apply
  def or     : Contract => Contract => Contract = Or.apply
  def cond   [O[_]: Monad]: O[Boolean] => Contract => Contract => Contract = Cond.apply
  def scale  [O[_]: Monad]: O[Double] => Contract => Contract = Scale.apply
  def when   [O[_]: Monad]: O[Boolean] => Contract => Contract = When.apply
  def anytime[O[_]: Monad]: O[Boolean] => Contract => Contract = Anytime.apply
  def until  [O[_]: Monad]: O[Boolean] => Contract => Contract = Until.apply
}
