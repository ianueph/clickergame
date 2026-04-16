package com.daniel.game.layout;

import com.daniel.game.ui.Renderable;

import java.util.ArrayList;
import java.util.List;

public class VerticalLayout implements Layout{

    private final List<Renderable> renderables = new ArrayList<>();
    private final int x;
    private int currentY;

    //TODO: Create proper lay-outing and rendering system.
    public VerticalLayout(int startX, int startY) {
        this.x = startX;
        this.currentY = startY;
    }

    @Override
    public void addElement(Renderable renderable) {
        renderable.setPos(x, currentY);
        BoundingBox bounds = renderable.getBounds();

        renderables.add(renderable);

        currentY += bounds.getHeight();
    }

    @Override
    public List<Renderable> getRenderables() {
        return renderables;
    }
}
