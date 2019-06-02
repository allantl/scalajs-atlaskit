package com.allantl.scalajs.atlaskit.dev

import com.allantl.scalajs.atlaskit.facade.Button
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom

object App {

  def main(args: Array[String]): Unit = {
    val Main =
      ScalaComponent
        .builder[Unit]("Main")
        .stateless
        .render_(<.div(
          Button(appearance = Button.Appearance.Primary, onClick = Callback(println("HelloWorld")))(
            "Click Me"
          )
        ))
        .build

    val container = dom.document.getElementById("root")
    Main().renderIntoDOM(container)
  }
}
