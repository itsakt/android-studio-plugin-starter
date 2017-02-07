package com.akt.awesomeplugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

/**
 * Created by AKT on 02-02-2017
 */
public class ButtonActionHandler extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        // TODO: Do something when button is pressed.
        System.out.println("Wow... it worked.");
    }
}
