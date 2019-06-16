package com.allantl.scalajs.atlaskit.facade

import com.payalabs.scalajs.react.bridge.{ReactBridgeComponent, WithProps}
import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomElement

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object Tabs extends ReactBridgeComponent {

  override lazy val componentValue = RawComponent

  def tab(label: String, content: VdomElement): Tab = {
    val p = (new js.Object).asInstanceOf[Tab]
    p.label = label
    p.content = content.rawElement
    p
  }

  def apply(
      tabs: Seq[Tab],
      onSelect: js.UndefOr[(Tab, Int) => Callback] = js.undefined
  ): WithProps = auto

  @js.native
  sealed trait Tab extends js.Object {
    var label: String = js.native
    var content: React.Element = js.native
  }

  @JSImport("@atlaskit/tabs", JSImport.Default)
  @js.native
  object RawComponent extends js.Object
}
