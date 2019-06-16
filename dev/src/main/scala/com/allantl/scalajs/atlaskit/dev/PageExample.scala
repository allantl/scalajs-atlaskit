package com.allantl.scalajs.atlaskit.dev

import com.allantl.scalajs.atlaskit.facade.{Grid, GridColumn, Page}
import japgolly.scalajs.react.vdom.html_<^._

object PageExample {

  val component: VdomElement =
    Page()(
      Grid()(
        GridColumn(8)(
          <.h1("Main Heading"),
          <.p(
            """Lorem ipsum dolor sit amet and consectetur adipisicing elit.
              |Blanditiis voluptatum perspiciatis doloribus dignissimos accusamus
              |commodi, nobis ut, error iusto, quas vitae nesciunt consequatur
              |possimus labore! Mollitia est quis minima asperiores."""
          )
        ),
        GridColumn(4)(
          <.h2("Sidebar"),
          <.p(
            """Lorem ipsum dolor sit amet, consectetur adipisicing elit.
              |Blanditiis voluptatum perspiciatis doloribus dignissimos accusamus
              |commodi, nobis ut, error iusto, quas vitae nesciunt consequatur
              |possimus labore! Mollitia est quis minima asperiores."""
          )
        )
      )
    )
}
