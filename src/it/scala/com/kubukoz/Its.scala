package com.kubukoz

import cats.Monoid
import org.scalatest.wordspec.AsyncWordSpec
import cats.effect._
import scala.concurrent.duration._

class Its() extends Tests() {
  import zio.ZIO

  ZIO.fail(42)

  IO.uncancelable { poll =>
    IO.sleep(10.seconds) *>
      poll(IO.sleep(5.seconds))
  }

  new Core()
  new CoreTest()
  new CoreIt()
}
