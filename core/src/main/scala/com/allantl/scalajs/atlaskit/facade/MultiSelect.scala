package com.allantl.scalajs.atlaskit.facade

import com.allantl.scalajs.atlaskit.facade.MultiSelect.MultiSelectOption
import com.payalabs.scalajs.react.bridge.{ReactBridgeComponent, WithProps}
import japgolly.scalajs.react.Callback

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object MultiSelect {

  def apply(
      options: Seq[MultiSelectOption],
      placeholder: js.UndefOr[String] = js.undefined,
      onChange: js.UndefOr[js.Array[MultiSelectOption] => Callback] = js.undefined,
      value: js.UndefOr[Seq[MultiSelectOption]] = js.undefined,
      isDisabled: js.UndefOr[Boolean] = js.undefined,
  ): WithProps = RawMultiSelect(
    options,
    placeholder,
    onChange,
    value,
    isDisabled
  )

  def option(label: String, value: String, meta: Option[String] = None): MultiSelectOption = {
    val p = (new js.Object).asInstanceOf[MultiSelectOption]
    p.label = label
    p.value = value
    p.meta = meta
    p
  }

  @js.native
  sealed trait MultiSelectOption extends js.Object {
    var label: String = js.native
    var value: String = js.native
    var meta: Option[String] = js.native
  }

}

private object RawMultiSelect extends ReactBridgeComponent {

  override lazy val componentValue = RawComponent

  def apply(
      options: Seq[MultiSelectOption],
      placeholder: js.UndefOr[String] = js.undefined,
      onChange: js.UndefOr[js.Array[MultiSelectOption] => Callback] = js.undefined,
      value: js.UndefOr[Seq[MultiSelectOption]] = js.undefined,
      isDisabled: js.UndefOr[Boolean] = js.undefined,
      isMulti: Boolean = true
  ): WithProps = auto

  @JSImport("@atlaskit/select", JSImport.Default)
  @js.native
  object RawComponent extends js.Object
}
