# Hejin

A library for implementing financial instruments, inspired by work from SL Peyton Jones and JM Eber [[1]](https://www.microsoft.com/en-us/research/publication/composing-contracts-an-adventure-in-financial-engineering/).

## Usage

```scala
import java.time.{LocalDateTime, ZonedDateTime, ZoneId, Month}
import io.github.leesq.hejin._
import io.github.leesq.hejin.Contract._

val t = ZonedDateTime.of(
  LocalDateTime.of(2018, Month.JANUARY, 20, 5, 30), 
  ZoneId.of("Asia/Singapore")
)

// define contract from primitive combinators
val zcb = when(at(t))(scale(konst(10))(one(SGD)))

// define a contract from other contracts
val europeanOption = when(at(t))(zcb or zero)
```

## Test

```bash
sbt test
```
