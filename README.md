# Hejin

A library for implementing financial instruments, based on work from SL Peyton Jones and JM Eber [[1]](https://www.microsoft.com/en-us/research/publication/composing-contracts-an-adventure-in-financial-engineering/).

## Usage

```scala
import java.time._
import cats.effect.{IO, Sync}
import xyz.leesq.hejin._
import xyz.leesq.hejin.Contract._

val t = ZonedDateTime.of(
  LocalDateTime.of(2018, Month.JANUARY, 20, 5, 30), 
  ZoneId.of("Asia/Singapore")
)

// Define a contract from primitive combinators
def zeroCouponBond[F[_]: Sync, T: Numeric](t: ZonedDateTime, x: T, k: Currency): Contract =
  when(at(t))(scale(konst(x))(one(k)))

val zcb = zeroCouponBond[IO, Int](t, 10, SGD)

// Define a contract from other contracts
val europeanOption = when(at[IO](t))(zcb or zero)
```

## Test

Run unit tests:

```bash
sbt test
```

Run code formatting:
```bash
sbt scalafmtAll
```
