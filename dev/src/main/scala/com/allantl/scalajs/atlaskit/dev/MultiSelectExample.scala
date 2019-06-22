package com.allantl.scalajs.atlaskit.dev

import com.allantl.scalajs.atlaskit.facade.MultiSelect
import com.allantl.scalajs.atlaskit.facade.MultiSelect.MultiSelectOption
import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.vdom.VdomElement

import scala.scalajs.js

object MultiSelectExample {

  val o1 =
    MultiSelect.option("MultiSelect", "MultiSelect")

  val options =
    Seq(
      o1,
      MultiSelect.option("MultiSelectTwo", "MultiSelectTwo")
    )

  val component: VdomElement =
    MultiSelect(
      options = options,
      onChange = (o: js.Array[MultiSelectOption]) => Callback(println(o.map(_.value).toSeq)),
      value = Seq(o1)
    )()

}
