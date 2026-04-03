package com.daniel.game.ui;

import org.jline.utils.AttributedString;

public interface Renderable {
    AttributedString getAttrString();
    int getX();
    void setPos(int x, int y);
}
