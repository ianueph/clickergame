package com.daniel.game.layout;

import com.daniel.game.ui.Renderable;

import java.util.List;

public interface Layout {
    List<Renderable> getRenderables();
    void addElement(Renderable renderable);
}
