package com.self.awareness.controller

import com.self.awareness.homescreen.buttons.{ButtonMediator, StudyModeButton, VisionModeButton}
import scalafx.Includes._
import scalafx.application.JFXApp3
import scalafx.geometry.{Insets, Pos}
import scalafx.scene.Scene
import scalafx.scene.layout.HBox
import scalafx.scene.paint.Color.Gray

object Start extends JFXApp3 {
    override def start(): Unit = {
        stage = new JFXApp3.PrimaryStage {
            title.value = "OnScreen-Reminder"
            width = 800
            height = 450
            scene = new Scene {
                fill = Gray
                content = new HBox {
                    alignment = Pos.Center
                    alignmentInParent = Pos.Center
                    spacing = 20.0
                    padding = Insets(50, 80, 50, 80)
                    val studyModeButton = new StudyModeButton
                    val visionModeButton = new VisionModeButton
                    val mediator = new ButtonMediator(studyModeButton, visionModeButton)
                    studyModeButton.setMediator(mediator)
                    visionModeButton.setMediator(mediator)
                    
                    children = Seq(
                      visionModeButton,
                      studyModeButton
                    )
                    visionModeButton.onAction
                }
            }
        }
    }
}
