package com.daniel.game.ui;

import com.daniel.game.layout.Inset;

public class IncrementButton extends Button {
    public IncrementButton(String text, Runnable action) {
        super("[ " + text + " ]", action);
    }

    public IncrementButton(String text, Runnable action, Inset margin) {
        super("[ " + text + " ]", action, margin);
    }
}
