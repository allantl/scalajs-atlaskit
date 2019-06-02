package com.allantl.scalajs.atlaskit.facade

import com.payalabs.scalajs.react.bridge.ReactBridgeComponentNoSpecialPropsNoChildren

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object Spinner extends ReactBridgeComponentNoSpecialPropsNoChildren {

  override lazy val componentValue = RawComponent

  @JSImport("@atlaskit/spinner", JSImport.Default)
  @js.native
  object RawComponent extends js.Object
}
