package com.allantl.scalajs.atlaskit.dev

import com.allantl.scalajs.atlaskit.facade.Select
import com.allantl.scalajs.atlaskit.facade.Select.SelectOption
import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.vdom.VdomElement

object SelectExample {

  val options: Seq[SelectOption] =
    Seq(
      Select.option("LabelOne", "ValueOne", Some("MetaOne")),
      Select.option("LabelTwo", "ValueTwo", Some("MetaTwo"))
    )

  val component: VdomElement =
    Select(
      options,
      onChange = (opt: Select.SelectOption) => Callback(println(opt.value))
    )()
}
