package com.self.awareness.homescreen.buttons

import scalafx.scene.control.Alert
import scalafx.scene.control.ButtonType
import scalafx.util.Duration

class StudyModeButton extends AlertButton("Study Mode", Duration(1500000)) {

    override def onAlert(): Unit = {
        val alert = new Alert(Alert.AlertType.Information)
        alert.title = text.getValue()
        alert.headerText = "Time for Revision"
        alert.contentText = "Revise contents for 5 minutes"

        val result = alert.showAndWait()
        result match {
            case Some(ButtonType.OK) =>
                timeline.foreach(_.playFromStart())
            case _ => // do Nothing
        }

    }
}
