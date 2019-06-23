package com.allantl.scalajs.atlaskit.facade

import com.payalabs.scalajs.react.bridge.{ReactBridgeComponent, WithPropsNoChildren}
import japgolly.scalajs.react.Callback

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object DatePicker extends ReactBridgeComponent {

  override lazy val componentValue = RawComponent

  def apply(
      onChange: js.UndefOr[String => Callback] = js.undefined
  ): WithPropsNoChildren = autoNoChildren

  @JSImport("@atlaskit/datetime-picker", "DatePicker")
  @js.native
  object RawComponent extends js.Object

}
