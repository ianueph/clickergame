package com.daniel.game;

public interface Clickable {
    void click();
    boolean isInside(int mouseX, int mouseY);
}
