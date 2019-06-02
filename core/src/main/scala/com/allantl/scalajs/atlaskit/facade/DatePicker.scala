package com.allantl.scalajs.atlaskit.facade

import com.payalabs.scalajs.react.bridge.{ReactBridgeComponent, WithProps}
import japgolly.scalajs.react.Callback

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object DatePicker extends ReactBridgeComponent {

  override lazy val componentValue = RawComponent

  def apply(
      onChange: js.UndefOr[String => Callback]
  ): WithProps = auto

  @JSImport("@atlaskit/datetime-picker", "DatePicker")
  @js.native
  object RawComponent extends js.Object

}
