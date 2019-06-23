package com.allantl.scalajs.atlaskit.facade

import com.allantl.scalajs.atlaskit.facade.AsyncSelect.AsyncSelectOption
import com.payalabs.scalajs.react.bridge.{ReactBridgeComponent, WithPropsNoChildren}
import japgolly.scalajs.react.Callback

import scala.concurrent.{ExecutionContext, Future}
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object AsyncSelect {

  def option(label: String, value: String): AsyncSelectOption = {
    val p = (new js.Object).asInstanceOf[AsyncSelectOption]
    p.label = label
    p.value = value
    p
  }

  def apply(
      loadOptions: String => Future[Seq[AsyncSelectOption]],
      placeholder: js.UndefOr[String] = js.undefined,
      value: js.UndefOr[Option[AsyncSelectOption]] = js.undefined,
      onChange: js.UndefOr[Option[AsyncSelectOption] => Callback] = js.undefined,
      isClearable: js.UndefOr[Boolean] = true,
      cacheOptions: js.UndefOr[Boolean] = true
  )(implicit ec: ExecutionContext): WithPropsNoChildren = RawAsyncSelect.apply(
    loadOptions,
    placeholder,
    value,
    onChange.map(cb => (so: AsyncSelectOption) => cb(Option(so))),
    isClearable,
    cacheOptions
  )

  @js.native
  sealed trait AsyncSelectOption extends js.Object {
    var label: String = js.native
    var value: String = js.native
  }
}

object RawAsyncSelect extends ReactBridgeComponent {

  override lazy val componentValue = RawComponent

  def apply(
      loadOptions: String => Future[Seq[AsyncSelectOption]],
      placeholder: js.UndefOr[String] = js.undefined,
      value: js.UndefOr[Option[AsyncSelectOption]] = js.undefined,
      onChange: js.UndefOr[AsyncSelectOption => Callback] = js.undefined,
      isClearable: js.UndefOr[Boolean] = js.undefined,
      cacheOptions: js.UndefOr[Boolean] = js.undefined
  )(implicit ec: ExecutionContext): WithPropsNoChildren = autoNoChildren

  @JSImport("@atlaskit/select", "AsyncSelect")
  @js.native
  object RawComponent extends js.Object
}
