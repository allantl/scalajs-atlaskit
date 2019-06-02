package com.allantl.scalajs.atlaskit.facade

import com.payalabs.scalajs.react.bridge.{ReactBridgeComponentNoSpecialProps, WithProps}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object ButtonGroup extends ReactBridgeComponentNoSpecialProps {

  @JSImport("@atlaskit/button", "ButtonGroup")
  @js.native
  object RawComponent extends js.Object

  def apply(): WithProps = auto
}
