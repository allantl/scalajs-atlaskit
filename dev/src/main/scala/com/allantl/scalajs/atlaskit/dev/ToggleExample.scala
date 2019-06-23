package com.allantl.scalajs.atlaskit.dev

import com.allantl.scalajs.atlaskit.facade.Toggle
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object ToggleExample {

  val component: VdomElement =
    Toggle(onChange = Callback(println("Toggled")))

}
