package com.daniel.game.ui;

public interface Clickable {
    void click();
    boolean isInside(int mouseX, int mouseY);
}
