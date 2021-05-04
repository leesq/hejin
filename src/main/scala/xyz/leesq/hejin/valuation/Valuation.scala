package xyz.leesq.hejin.valuation

import cats.Applicative
import cats.syntax.all._
import cats.effect.Sync

import xyz.leesq.hejin._

type Monies[T] = Map[Currency, T]

//def valuation[F[_]: Applicative, T: Numeric](c: Contract): F[Monies[T]] = c match {
//  case _: Zero.type => Map.empty[Currency, T].pure[F]
//  case _: One => Map(c.k -> summon[Numeric[T]].one).pure[F]
//  case c: xyz.leesq.hejin.Give =>
//    for {
//      value <- valuation(c.c)
//    } yield value map { case (k, v) => k -> summon[Numeric[T]].negate(v) }
//  case _: xyz.leesq.hejin.And =>
//  case _: xyz.leesq.hejin.Or =>
//  case _: xyz.leesq.hejin.Cond[_] =>
//  case _: xyz.leesq.hejin.Scale[_, _] =>
//  case _: xyz.leesq.hejin.When[_] =>
//  case _: xyz.leesq.hejin.Anytime[_] =>
//  case _: xyz.leesq.hejin.Until[_] =>
//}

trait Valuation[F, C, T]:
  extension(c: C) def valuation[F[_]: Applicative, T: Numeric, C <: Contract]: F[Monies[T]]
