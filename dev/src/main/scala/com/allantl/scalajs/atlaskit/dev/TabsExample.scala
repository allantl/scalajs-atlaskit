package com.allantl.scalajs.atlaskit.dev

import com.allantl.scalajs.atlaskit.facade.Tabs
import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.vdom.html_<^._

object TabsExample {

  val firstTab =
    Tabs.tab(
      "Tab One",
      <.div("Inside first tab")
    )

  val secondTab =
    Tabs.tab(
      "Tab Two",
      <.div("Inside second tab")
    )

  val component: VdomElement =
    Tabs(
      Seq(firstTab, secondTab),
      (_: Tabs.Tab, index: Int) => Callback(println("Index No: " + index))
    )()
}
