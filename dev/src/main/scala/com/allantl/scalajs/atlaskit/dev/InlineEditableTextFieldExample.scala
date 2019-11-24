package com.allantl.scalajs.atlaskit.dev

import com.allantl.scalajs.atlaskit.facade.InlineEditableTextField
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object InlineEditableTextFieldExample {

  case class State(value: String)

  val rawComponent =
    ScalaComponent
      .builder[Unit]("InlineEditableTextFieldExample")
      .initialState(State("Hello"))
      .renderS(($, s) =>
        InlineEditableTextField(
          defaultValue = "Default",
          isRequired = true,
          onConfirm = (value: Option[String]) =>
            Callback(println(value)) >> $.setState(State(value.getOrElse(""))),
          startWithEditViewOpen = true
        )
      )
      .build

  val component: VdomElement = rawComponent()
}
