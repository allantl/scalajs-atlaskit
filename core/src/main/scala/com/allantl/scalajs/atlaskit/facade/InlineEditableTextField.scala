package com.allantl.scalajs.atlaskit.facade

import com.payalabs.scalajs.react.bridge.{ReactBridgeComponent, WithPropsNoChildren}
import japgolly.scalajs.react.Callback

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.util.Try

object InlineEditableTextField extends ReactBridgeComponent {

  private final val internalOnConfirm = (v: String, f: Option[String] => Callback) => {
    val maybeV = if (v.isEmpty) None else Try(v).toOption
    f(maybeV)
  }

  def apply(
      defaultValue: js.UndefOr[String] = js.undefined,
      label: js.UndefOr[String] = js.undefined,
      readViewFitContainerWidth: js.UndefOr[Boolean] = js.undefined,
      onConfirm: js.UndefOr[Option[String] => Callback] = js.undefined,
      startWithEditViewOpen: js.UndefOr[Boolean] = js.undefined,
      validate: js.UndefOr[String => Option[String]] = js.undefined,
      isRequired: js.UndefOr[Boolean] = js.undefined
  ): WithPropsNoChildren = RawInlineEditableTextField(
    defaultValue.getOrElse(""),
    label,
    readViewFitContainerWidth,
    onConfirm.map(f => (v: String) => internalOnConfirm(v, f)),
    startWithEditViewOpen,
    validate.map(fn => (s: String) => fn(s).orNull),
    isRequired
  )
}

private object RawInlineEditableTextField extends ReactBridgeComponent {

  override lazy val componentValue = RawComponent

  def apply(
      defaultValue: String,
      label: js.UndefOr[String] = js.undefined,
      readViewFitContainerWidth: js.UndefOr[Boolean] = js.undefined,
      onConfirm: js.UndefOr[String => Callback] = js.undefined,
      startWithEditViewOpen: js.UndefOr[Boolean] = js.undefined,
      validate: js.UndefOr[String => String] = js.undefined,
      isRequired: js.UndefOr[Boolean] = js.undefined
  ): WithPropsNoChildren = autoNoChildren

  @JSImport("@atlaskit/inline-edit", "InlineEditableTextfield")
  @js.native
  object RawComponent extends js.Object
}
