package com.allantl.scalajs.atlaskit.dev

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom

object App {

  val examples = Seq(
    ButtonExample.component,
    ButtonGroupExample.component,
    DatePickerExample.component,
    ToggleExample.component,
    PageExample.component,
    PageHeaderExample.component,
    TabsExample.component,
    SelectExample.component,
    TextFieldExample.component,
    InlineEditableTextFieldExample.component,
    MultiSelectExample.component,
    AsyncSelectExample.component,
    AsyncMultiSelectExample.component
  )

  def main(args: Array[String]): Unit = {
    val Main =
      ScalaComponent
        .builder[Unit]("Main")
        .stateless
        .render_(
          <.div(
            ^.padding := 20.px,
            withMargins(examples)
          )
        )
        .build

    val container = dom.document.getElementById("root")
    Main().renderIntoDOM(container)
  }

  def withMargins(element: Seq[VdomElement]) =
    element.toVdomArray { el =>
      <.div(
        ^.marginTop := 20.px,
        el
      )
    }
}
