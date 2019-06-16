package com.allantl.scalajs.atlaskit.dev

import com.allantl.scalajs.atlaskit.facade.Button
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object ButtonExample {

  val component: VdomElement =
    Button(onClick = Callback(println("CLICK")), appearance = Button.Appearance.Primary)(
      "Click Me"
    )
}
