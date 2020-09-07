package xyz.leesq.hejin

import java.time.ZonedDateTime

import cats.Applicative
import cats.syntax.all._
import cats.effect.Sync

sealed trait Contract
case object Zero                                                 extends Contract
case class One(k: Currency)                                      extends Contract
case class Give(c: Contract)                                     extends Contract
case class And(c1: Contract, c2: Contract)                       extends Contract
case class Or(c1: Contract, c2: Contract)                        extends Contract
case class Cond[F[_]](b: F[Boolean], c1: Contract, c2: Contract) extends Contract
case class Scale[F[_], T: Numeric](o: F[T], c: Contract)         extends Contract
case class When[F[_]](o: F[Boolean], c: Contract)                extends Contract
case class Anytime[F[_]](o: F[Boolean], c: Contract)             extends Contract
case class Until[F[_]](o: F[Boolean], c: Contract)               extends Contract

object Contract {
  implicit class ContractOps(c1: Contract) {
    def and(c2: Contract): Contract = And(c1, c2)
    def or(c2: Contract): Contract  = Or(c1, c2)
  }

  val zero: Contract             = Zero
  val one: Currency => One       = One.apply
  val give: Contract => Contract = Give.apply

  def cond[F[_]](b: F[Boolean])(c1: Contract)(c2: Contract): Contract         = Cond(b, c1, c2)
  def scale[F[_], T: Numeric](o: F[T])(c: Contract): Contract                 = Scale(o, c)
  def when[F[_]](b: F[Boolean])(c: Contract): Contract                        = When(b, c)
  def anytime[F[_]](o: F[Boolean])(c: Contract): Contract                     = Anytime(o, c)
  def until[F[_]](o: F[Boolean])(c: Contract): Contract                       = Until(o, c)
  def konst[F[_]: Applicative, A](a: A): F[A]                                 = a.pure[F]
  def lift[F[_]: Applicative, A, B](f: A => B): F[A] => F[B]                  = Applicative[F].lift(f)
  def lift2[F[_]: Applicative, A, B, C](f: (A, B) => C): (F[A], F[B]) => F[C] = Applicative[F].ap2[A, B, C](f.pure[F])
  def at[F[_]: Sync](t: ZonedDateTime): F[Boolean]                            = Sync[F].delay(t.isBefore(ZonedDateTime.now()))
}
