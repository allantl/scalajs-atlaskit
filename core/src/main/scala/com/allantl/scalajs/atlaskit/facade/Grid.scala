package com.allantl.scalajs.atlaskit.facade

import com.allantl.value.entry.ValueEntry
import com.payalabs.scalajs.react.bridge.{ReactBridgeComponent, WithProps}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object Grid {

  def apply(spacing: Spacing = Spacing.Cosy, layout: Layout = Layout.Default): WithProps =
    RawGrid(spacing = spacing.value, layout = layout.value)

  sealed trait Layout extends ValueEntry.LowerCase
  sealed trait Spacing extends ValueEntry.LowerCase

  object Layout {
    case object Default extends Layout
    case object Fluid extends Layout
  }

  object Spacing {
    case object Cosy extends Spacing
    case object Compact extends Spacing
    case object Comfortable extends Spacing
  }
}

private object RawGrid extends ReactBridgeComponent {

  override lazy val componentValue = RawComponent

  def apply(
      spacing: js.UndefOr[String] = js.undefined,
      layout: js.UndefOr[String] = js.undefined
  ): WithProps = auto

  @JSImport("@atlaskit/page", "Grid")
  @js.native
  object RawComponent extends js.Object
}

object GridColumn extends ReactBridgeComponent {

  override lazy val componentValue = RawComponent

  def apply(medium: Int): WithProps = auto

  @JSImport("@atlaskit/page", "GridColumn")
  @js.native
  object RawComponent extends js.Object
}
