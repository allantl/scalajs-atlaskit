package com.allantl.scalajs.atlaskit.facade

import com.payalabs.scalajs.react.bridge.{ReactBridgeComponent, WithProps}
import japgolly.scalajs.react.Callback

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object Select extends ReactBridgeComponent {

  def option(label: String, value: String, meta: Option[String] = None): SelectOption = {
    val p = (new js.Object).asInstanceOf[SelectOption]
    p.label = label
    p.value = value
    p.meta = meta
    p
  }

  def apply(
      options: Seq[SelectOption],
      placeholder: js.UndefOr[String] = js.undefined,
      value: js.UndefOr[SelectOption] = js.undefined,
      onChange: js.UndefOr[SelectOption => Callback] = js.undefined,
      isDisabled: js.UndefOr[Boolean] = js.undefined
  ): WithProps = auto

  @js.native
  trait SelectOption extends js.Object {
    var label: String = js.native
    var value: String = js.native
    var meta: Option[String] = js.native
  }

  override lazy val componentValue = RawComponent

  @JSImport("@atlaskit/select", JSImport.Default)
  @js.native
  object RawComponent extends js.Object
}
