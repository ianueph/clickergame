package com.daniel.game.layout;

import com.daniel.game.ui.EmptyLine;
import com.daniel.game.ui.Renderable;

import java.util.ArrayList;
import java.util.List;

public class VerticalLayout {

    private final List<Renderable> renderables = new ArrayList<>();
    private final int x;
    private int currentY;

    //TODO: Create proper lay-outing and rendering system.
    public VerticalLayout(int startX, int startY) {
        this.x = startX;
        this.currentY = 1;

        addSpacing(startY);
    }

    public void add(Renderable renderable) {
        renderable.setPos(x, currentY);
        renderables.add(renderable);
        currentY++;
    }

    public void addSpacing(int lines) {
        for (int i = 0; i < lines; i++) {
            add(new EmptyLine());
        }
    }

    public List<Renderable> getRenderables() {
        return renderables;
    }
}
