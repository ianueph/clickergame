package com.daniel.game.ui;

import com.daniel.game.layout.BoundingBox;
import org.jline.utils.AttributedString;

public interface Renderable {
    AttributedString getAttrString();
    int getX();
    void setPos(int x, int y);
    void setBBox(int x0, int y0, int x1, int y1);
    void setBBox(BoundingBox bBox);
}
