package com.allantl.scalajs.atlaskit.facade

import com.payalabs.scalajs.react.bridge.{ReactBridgeComponent, WithProps}
import japgolly.scalajs.react.vdom.VdomElement

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object PageHeader extends ReactBridgeComponent {

  override lazy val componentValue = RawComponent

  def apply(actions: VdomElement): WithProps = auto

  @JSImport("@atlaskit/page-header", JSImport.Default)
  @js.native
  object RawComponent extends js.Object
}
