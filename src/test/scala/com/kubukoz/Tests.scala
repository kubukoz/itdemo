package com.kubukoz

import org.scalatest.wordspec.AnyWordSpec

class Tests() extends AnyWordSpec {

  import zio._

  ZIO.succeed(42)

  new Core()
  new CoreTest()
}
