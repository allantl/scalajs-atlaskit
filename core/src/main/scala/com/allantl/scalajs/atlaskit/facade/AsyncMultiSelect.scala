package com.allantl.scalajs.atlaskit.facade

import com.allantl.scalajs.atlaskit.facade.AsyncMultiSelect.AsyncMultiSelectOption
import com.payalabs.scalajs.react.bridge.{ReactBridgeComponent, WithPropsNoChildren}
import japgolly.scalajs.react.Callback

import scala.concurrent.{ExecutionContext, Future}
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object AsyncMultiSelect {

  def option(label: String, value: String): AsyncMultiSelectOption = {
    val p = (new js.Object).asInstanceOf[AsyncMultiSelectOption]
    p.label = label
    p.value = value
    p
  }

  def apply(
      loadOptions: String => Future[Seq[AsyncMultiSelectOption]],
      placeholder: js.UndefOr[String] = js.undefined,
      value: js.UndefOr[Seq[AsyncMultiSelectOption]] = js.undefined,
      onChange: js.UndefOr[Seq[AsyncMultiSelectOption] => Callback] = js.undefined,
      isClearable: js.UndefOr[Boolean] = true,
      cacheOptions: js.UndefOr[Boolean] = true
  )(implicit ec: ExecutionContext): WithPropsNoChildren =
    RawAsyncMultiSelect.apply(
      loadOptions,
      placeholder,
      value,
      onChange.map(cb => (arr: js.Array[AsyncMultiSelectOption]) => cb(arr.toSeq)),
      isClearable,
      cacheOptions,
      isMulti = true
    )

  @js.native
  sealed trait AsyncMultiSelectOption extends js.Object {
    var label: String = js.native
    var value: String = js.native
  }

}

private object RawAsyncMultiSelect extends ReactBridgeComponent {

  override lazy val componentValue = RawComponent

  def apply(
      loadOptions: String => Future[Seq[AsyncMultiSelectOption]],
      placeholder: js.UndefOr[String] = js.undefined,
      value: js.UndefOr[Seq[AsyncMultiSelectOption]] = js.undefined,
      onChange: js.UndefOr[js.Array[AsyncMultiSelectOption] => Callback] = js.undefined,
      isClearable: js.UndefOr[Boolean] = js.undefined,
      cacheOptions: js.UndefOr[Boolean] = js.undefined,
      isMulti: js.UndefOr[Boolean] = js.undefined,
  )(implicit ec: ExecutionContext): WithPropsNoChildren = autoNoChildren

  @JSImport("@atlaskit/select", "AsyncSelect")
  @js.native
  object RawComponent extends js.Object
}
