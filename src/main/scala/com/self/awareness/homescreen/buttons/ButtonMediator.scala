package com.self.awareness.homescreen.buttons

class ButtonMediator(buttons: AlertButton*) {
    def stopOtherTimelines(activeButton: AlertButton): Unit = {
        for (button <- buttons if button != activeButton) {
            println("disabling timeline for ", button.text.getValue())
            button.timeline.foreach(_.stop())
        }
    }
}
