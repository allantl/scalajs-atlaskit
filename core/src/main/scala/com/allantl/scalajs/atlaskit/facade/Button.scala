package com.allantl.scalajs.atlaskit.facade

import com.allantl.value.entry.ValueEntry
import com.payalabs.scalajs.react.bridge.{ReactBridgeComponent, WithProps}
import japgolly.scalajs.react._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object Button {

  def apply(appearance: Appearance = Appearance.Default, onClick: Callback): WithProps =
    RawButton(appearance.value, onClick.toJsFn)

  sealed trait Appearance extends ValueEntry.LowerCase

  object Appearance {
    case object Link extends Appearance
    case object Default extends Appearance
    case object Primary extends Appearance
    case object Subtle extends Appearance
  }
}

private object RawButton extends ReactBridgeComponent {

  override lazy val componentValue = RawComponent

  def apply(
      appearance: String,
      onClick: () => Unit
  ): WithProps = auto

  @JSImport("@atlaskit/button", JSImport.Default)
  @js.native
  object RawComponent extends js.Object
}
