package com.daniel.game.layout;

import com.daniel.game.ui.Renderable;
import com.daniel.game.ui.UIComponent;

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
    public void addElement(UIComponent component) {
        currentY += component.getMarginTop();

        component.setPos(x, currentY);
        renderables.add(component);

        currentY += component.getMarginBottom() + component.getBounds().getHeight();
    }

    @Override
    public List<Renderable> getRenderables() {
        return renderables;
    }
}
