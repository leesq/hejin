package io.github.leesq.hejin

import java.time.ZonedDateTime

import cats.Applicative
import cats.implicits._
import cats.effect._

sealed trait Contract

case object Zero extends Contract
case class One    (k: Currency) extends Contract
case class Give   (c: Contract) extends Contract
case class And    (c1: Contract, c2: Contract) extends Contract
case class Or     (c1: Contract, c2: Contract) extends Contract
case class Cond   [Obs[_]](b: Obs[Boolean], c1: Contract, c2: Contract) extends Contract
case class Scale  [Obs[_]](o: Obs[Double], c: Contract) extends Contract
case class When   [Obs[_]](o: Obs[Boolean], c: Contract) extends Contract
case class Anytime[Obs[_]](o: Obs[Boolean], c: Contract) extends Contract
case class Until  [Obs[_]](o: Obs[Boolean], c: Contract) extends Contract

object Contract {

  implicit class ContractOps(c1: Contract) {
    def and(c2: Contract): Contract = And(c1, c2)
    def or(c2: Contract): Contract = Or(c1, c2)
  }

  val zero: Contract = Zero

  val one : Currency => One = One.apply

  val give: Contract => Contract = Give.apply

  def cond   [Obs[_]]: Obs[Boolean] => Contract => Contract => Contract = (Cond.apply[Obs] _).curried

  def scale  [Obs[_]]: Obs[Double] => Contract => Contract = (Scale.apply[Obs] _).curried

  def when   [Obs[_]]: Obs[Boolean] => Contract => Contract = (When.apply[Obs] _).curried

  def anytime[Obs[_]]: Obs[Boolean] => Contract => Contract = (Anytime.apply[Obs] _).curried

  def until  [Obs[_]]: Obs[Boolean] => Contract => Contract = (Until.apply[Obs] _).curried

  def konst[Obs[_]: Applicative, A](a: A): Obs[A] = a.pure[Obs]

  def lift [Obs[_]: Applicative, A, B](f: A => B): Obs[A] => Obs[B] = Applicative[Obs].lift(f)

  def lift2[Obs[_]: Applicative, A, B, C](f: (A, B) => C): (Obs[A], Obs[B]) => Obs[C] = Applicative[Obs].ap2[A, B, C](f.pure[Obs])

  def at(t: ZonedDateTime): IO[Boolean] = IO { t.isEqual(ZonedDateTime.now()) }

}
