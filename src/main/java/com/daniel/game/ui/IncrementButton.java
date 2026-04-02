package com.daniel.game.ui;

public class IncrementButton extends Button {
    public IncrementButton(int x, int y, String text, Runnable action) {
        super(x, y, "[ " + text + " ]", action);
    }
}
