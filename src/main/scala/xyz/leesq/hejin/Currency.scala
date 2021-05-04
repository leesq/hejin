package xyz.leesq.hejin

enum Currency(val code: String):
  case CNY extends Currency("CNY")
  case HKD extends Currency("HKD")
  case SGD extends Currency("SGD")
  case THB extends Currency("THB")
