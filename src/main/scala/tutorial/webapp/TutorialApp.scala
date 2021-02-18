package tutorial.webapp

import org.scalajs.dom
import org.scalajs.dom.document
import scala.scalajs.js.annotation.JSExportTopLevel

object TutorialApp {
  def main(args: Array[String]): Unit = {
    // Prints to the console
    println("Hello world!")

    // We can use the Function we wrote to append a TextNode to an existing DomNode
    appendPar(document.body, "Hello World")

    // Instead of accessing exisiting Nodes in the DOM, we can create and insert our own
    val button = document.createElement("button")
    button.textContent = "This Button is generated from the ScalaJS script"
    button.addEventListener("click", { (e: dom.MouseEvent) =>
      addClickedMessage()
    })
    document.body.appendChild(button)

    // Instead of setting up the UI asynchronously in the main, we can wait for the DOM to load and then render it:
    document.addEventListener("DOMContentLoaded", { (e: dom.Event) =>
      setupUI()
    })
  }

  def setupUI(): Unit = {
    val button = document.createElement("button")
    button.textContent = "Click me!"
    button.addEventListener("click", { (e: dom.MouseEvent) =>
      addClickedMessage()
    })
    document.body.appendChild(button)

    appendPar(document.body, "Hello World")
  }

  // A function that allows us to append a TextNode to an existing DOM NODE
  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    parNode.textContent = text
    targetNode.appendChild(parNode)
  }

  // The JSExportTopLevel annotation allows to create a Top-Level Function in Javascript
  @JSExportTopLevel("addClickedMessage")
  def addClickedMessage(): Unit = {
    appendPar(document.body, "You clicked the button!")
  }


}