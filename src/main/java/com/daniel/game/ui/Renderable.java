package com.daniel.game.ui;

import org.jline.utils.AttributedString;

public interface Renderable {
    void setPos(int x, int y);
    AttributedString getAttrString();
    int getX();
}
