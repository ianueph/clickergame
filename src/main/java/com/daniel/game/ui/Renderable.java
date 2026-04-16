package com.daniel.game.ui;

import com.daniel.game.layout.BoundingBox;
import com.daniel.game.layout.FrameConstructor;

public interface Renderable {
    void setPos(int x, int y);
    void setBBox(BoundingBox bBox);
    void render(FrameConstructor frame);

    BoundingBox getBounds();
}
