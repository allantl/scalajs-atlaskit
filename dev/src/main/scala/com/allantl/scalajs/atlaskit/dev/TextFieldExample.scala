package com.allantl.scalajs.atlaskit.dev

import com.allantl.scalajs.atlaskit.facade.{NumberField, TextField}
import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.html_<^._

object TextFieldExample {

  val component: VdomElement =
    <.div(
      TextField(defaultValue = "Hello"),
      NumberField(defaultValue = 10),
      TextField(onChange = (o: Option[String]) => Callback(println(o))),
      NumberField(onChange = (o: Option[Int]) => Callback(println(o)))
    )
}
