package com.allantl.scalajs.atlaskit.facade

import com.payalabs.scalajs.react.bridge.{ReactBridgeComponent, WithPropsNoChildren}
import japgolly.scalajs.react.{Callback, ReactEventFromInput}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Atlaskit textfield, for Number check `Numberfield`
  */
object TextField {

  private final val internalOnChange = (e: ReactEventFromInput, f: Option[String] => Callback) => {
    val v = e.target.value
    val maybeV = if (v.isEmpty) None else Some(v)
    f(maybeV)
  }

  def apply(
      defaultValue: js.UndefOr[String] = js.undefined,
      value: js.UndefOr[String] = js.undefined,
      width: js.UndefOr[Int] = js.undefined,
      isRequired: js.UndefOr[Boolean] = js.undefined,
      isInvalid: js.UndefOr[Boolean] = js.undefined,
      isDisabled: js.UndefOr[Boolean] = js.undefined,
      isReadOnly: js.UndefOr[Boolean] = false,
      autoFocus: js.UndefOr[Boolean] = js.undefined,
      onChange: js.UndefOr[Option[String] => Callback] = js.undefined,
  ): WithPropsNoChildren =
    RawTextField(
      defaultValue,
      value,
      width,
      isRequired,
      isInvalid,
      isDisabled,
      isReadOnly,
      autoFocus,
      onChange.map(f => (e: ReactEventFromInput) => internalOnChange(e, f))
    )
}

private object RawTextField extends ReactBridgeComponent {

  override lazy val componentValue = RawComponent

  def apply(
      defaultValue: js.UndefOr[String] = js.undefined,
      value: js.UndefOr[String] = js.undefined,
      width: js.UndefOr[Int] = js.undefined,
      isRequired: js.UndefOr[Boolean] = js.undefined,
      isInvalid: js.UndefOr[Boolean] = js.undefined,
      isDisabled: js.UndefOr[Boolean] = js.undefined,
      isReadOnly: js.UndefOr[Boolean] = false,
      autoFocus: js.UndefOr[Boolean] = js.undefined,
      onChange: js.UndefOr[ReactEventFromInput => Callback] = js.undefined,
  ): WithPropsNoChildren = autoNoChildren

  @JSImport("@atlaskit/textfield", JSImport.Default)
  @js.native
  object RawComponent extends js.Object
}
