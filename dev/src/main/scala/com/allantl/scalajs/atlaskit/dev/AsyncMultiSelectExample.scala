package com.allantl.scalajs.atlaskit.dev

import com.allantl.scalajs.atlaskit.facade.AsyncMultiSelect
import com.allantl.scalajs.atlaskit.facade.AsyncMultiSelect.AsyncMultiSelectOption
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.{AsyncCallback, Callback}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object AsyncMultiSelectExample {

  val loadOptions =
    (s: String) =>
      AsyncCallback.pure(Seq(AsyncMultiSelect.option(s, s))).delay(1.seconds).unsafeToFuture()

  val component: VdomElement =
    AsyncMultiSelect(
      loadOptions,
      placeholder = "Placeholder",
      onChange = (options: Seq[AsyncMultiSelectOption]) => Callback(println(options.map(_.label).mkString(", ")))
    )
}
