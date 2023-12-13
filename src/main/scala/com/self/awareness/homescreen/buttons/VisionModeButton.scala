package com.self.awareness.homescreen.buttons

import scalafx.scene.control.Alert
import scalafx.scene.control.ButtonType
import scalafx.util.Duration

class VisionModeButton extends AlertButton("Vision Mode", Duration(1200000)) {
    
    override def onAlert(): Unit = {
        val alert = new Alert(Alert.AlertType.Information)
        alert.title = text.getValue()
        alert.headerText = "Rest for EYES!!!"
        alert.contentText = "View 20 feet away for 20 seconds"

        val result = alert.showAndWait()
        result match {
            case Some(ButtonType.OK) =>
                timeline.foreach(_.playFromStart())
            case _ => // do Nothing
        }

    }
}
