package com.allantl.scalajs.atlaskit.facade

import com.payalabs.scalajs.react.bridge.{ReactBridgeComponent, WithProps}
import japgolly.scalajs.react.{Callback, ReactEventFromInput}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.util.Try

object NumberField {

  private final val internalOnChange = (e: ReactEventFromInput, f: Option[Int] => Callback) => {
    val v = e.target.value
    val maybeV = if (v.isEmpty) None else Try(v.toInt).toOption
    f(maybeV)
  }

  def apply(
      defaultValue: js.UndefOr[Int] = js.undefined,
      value: js.UndefOr[Int] = js.undefined,
      width: js.UndefOr[Int] = js.undefined,
      isRequired: js.UndefOr[Boolean] = js.undefined,
      isInvalid: js.UndefOr[Boolean] = js.undefined,
      isDisabled: js.UndefOr[Boolean] = js.undefined,
      isReadOnly: js.UndefOr[Boolean] = false,
      autoFocus: js.UndefOr[Boolean] = js.undefined,
      onChange: js.UndefOr[Option[Int] => Callback] = js.undefined,
  ): WithProps =
    RawNumberField(
      "number",
      defaultValue.map(_.toString),
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

private object RawNumberField extends ReactBridgeComponent {

  override lazy val componentValue = RawComponent

  def apply(
      `type`: String,
      defaultValue: js.UndefOr[String] = js.undefined,
      value: js.UndefOr[Int] = js.undefined,
      width: js.UndefOr[Int] = js.undefined,
      isRequired: js.UndefOr[Boolean] = js.undefined,
      isInvalid: js.UndefOr[Boolean] = js.undefined,
      isDisabled: js.UndefOr[Boolean] = js.undefined,
      isReadOnly: js.UndefOr[Boolean] = false,
      autoFocus: js.UndefOr[Boolean] = js.undefined,
      onChange: js.UndefOr[ReactEventFromInput => Callback] = js.undefined,
  ): WithProps = auto

  @JSImport("@atlaskit/textfield", JSImport.Default)
  @js.native
  object RawComponent extends js.Object
}
