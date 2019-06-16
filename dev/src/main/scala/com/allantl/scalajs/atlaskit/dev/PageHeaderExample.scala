package com.allantl.scalajs.atlaskit.dev

import com.allantl.scalajs.atlaskit.facade.{Button, ButtonGroup, PageHeader}
import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.vdom.html_<^._

object PageHeaderExample {

  val actions = ButtonGroup()(
    Button(onClick = Callback.empty)("Button1"),
    Button(onClick = Callback.empty)("Button2"),
  )

  val component: VdomElement =
    PageHeader(actions = actions)("PageHeader")
}
