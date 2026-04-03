package com.daniel.game.ui;

public class IncrementButton extends Button {
    public IncrementButton(String text, Runnable action) {
        super("[ " + text + " ]", action);
    }
}
