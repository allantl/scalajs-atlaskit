package com.allantl.scalajs.atlaskit.facade

import com.allantl.value.entry.ValueEntry
import com.payalabs.scalajs.react.bridge.{ReactBridgeComponent, WithProps}
import japgolly.scalajs.react.Callback

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object Toggle {

  def apply(
      size: ToggleSize = ToggleSize.Regular,
      isDefaultChecked: Boolean = false,
      onChange: js.UndefOr[Callback] = js.undefined
  ): WithProps = RawToggle(size.value, isDefaultChecked, onChange)

  sealed trait ToggleSize extends ValueEntry.LowerCase
  object ToggleSize {
    case object Regular extends ToggleSize
    case object Large extends ToggleSize
  }
}

object RawToggle extends ReactBridgeComponent {

  override lazy val componentValue = RawComponent

  def apply(
      size: String,
      isChecked: Boolean,
      onChange: js.UndefOr[Callback]
  ): WithProps = auto

  @JSImport("@atlaskit/toggle", JSImport.Default)
  @js.native
  object RawComponent extends js.Object
}
