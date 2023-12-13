package com.self.awareness.homescreen.buttons

import javafx.event.ActionEvent
import scalafx.animation.KeyFrame
import scalafx.animation.Timeline
import scalafx.application.Platform
import scalafx.scene.control.Button
import scalafx.util.Duration
import scalafx.geometry.Pos

abstract class AlertButton(
    text: String,
    waitTime: Duration
) extends Button {

    alignment = Pos.Center
    alignmentInParent = Pos.Center
    prefHeight = 200
    prefWidth = 300

    this.text = text
    var timeline: Option[Timeline] = None
    var mediator: Option[ButtonMediator] = None

    onAction = (event: ActionEvent) => {
        println(this.text, mediator == null)
        mediator.foreach(_.stopOtherTimelines(this))
        println("enable timeline for ", this.text, this.waitTime, waitTime)
        timeline = Some(new Timeline {
            cycleCount = Timeline.Indefinite
            keyFrames = Seq(
              KeyFrame(
                waitTime,
                onFinished = _ =>
                    Platform.runLater {
                        println("onalert started")
                        timeline.foreach(_.stop())
                        onAlert()
                    }
              )
            )
        })

        timeline.foreach(_.play())
    }

    def onAlert(): Unit

    def setMediator(mediator: ButtonMediator) = {
        println("set mediator for: ", this.text)
        this.mediator = Some(mediator)
    }
}
