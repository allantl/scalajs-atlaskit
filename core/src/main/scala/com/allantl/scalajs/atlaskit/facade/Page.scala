package com.allantl.scalajs.atlaskit.facade

import com.payalabs.scalajs.react.bridge.{ReactBridgeComponentNoSpecialProps, WithProps}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object Page extends ReactBridgeComponentNoSpecialProps {

  override lazy val componentValue = RawComponent

  def apply(): WithProps = auto

  @JSImport("@atlaskit/page", JSImport.Default)
  @js.native
  object RawComponent extends js.Object
}
