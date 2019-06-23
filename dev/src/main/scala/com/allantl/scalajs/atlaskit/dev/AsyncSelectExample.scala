package com.allantl.scalajs.atlaskit.dev

import com.allantl.scalajs.atlaskit.facade.AsyncSelect
import japgolly.scalajs.react.{AsyncCallback, Callback}
import japgolly.scalajs.react.vdom.VdomElement

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object AsyncSelectExample {

  val loadOptions =
    (s: String) =>
      AsyncCallback.pure(List(AsyncSelect.option(s, s))).delay(1.seconds).unsafeToFuture()

  val component: VdomElement =
    AsyncSelect(
      loadOptions,
      placeholder = "Placeholder",
      onChange = (opt: Option[AsyncSelect.AsyncSelectOption]) => Callback(println(opt.map(_.label)))
    )
}
