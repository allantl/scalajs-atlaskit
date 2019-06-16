package com.allantl.scalajs.atlaskit.dev

import com.allantl.scalajs.atlaskit.facade.{Button, ButtonGroup}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object ButtonGroupExample {

  val component: VdomElement =
    ButtonGroup()(
      Button(onClick = Callback(println("CLICK1")))("CLICK1"),
      Button(onClick = Callback(println("CLICK2")))("CLICK2"),
      Button(onClick = Callback(println("CLICK3")))("CLICK3")
    )
}
