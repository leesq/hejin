# Hejin

A library for implementing financial instruments, inspired by work from SL Peyton Jones and JM Eber [[1]](https://www.microsoft.com/en-us/research/publication/composing-contracts-an-adventure-in-financial-engineering/).

## Usage

```scala
import io.github.leesq.hejin.Contract._
import io.github.leesq.hejin.Currency._
val contract = one(TWD) and one(SGD) 
```

## Test

```bash
sbt test
```
