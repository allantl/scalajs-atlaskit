package com.allantl.scalajs.atlaskit.dev

import com.allantl.scalajs.atlaskit.facade.DatePicker
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object DatePickerExample {

  val component: VdomElement =
    DatePicker((date: String) => Callback(println(date)))()

}
