package com.daniel.game.ui;

import java.util.ArrayList;
import java.util.List;

public class VerticalLayout {

    private final List<Renderable> renderables = new ArrayList<>();
    private final int x;
    private int currentY;

    //TODO: Create proper lay-outing and rendering system.
    public VerticalLayout(int startX, int startY) {
        this.x = startX;
        this.currentY = startY;

        addSpacing(startY - 1, false);
    }

    public void add(Renderable renderable) {
        renderable.setPos(x, currentY);
        renderables.add(renderable);
        currentY++;
    }

    public void addSpacing(int lines) {
        for (int i = 0; i < lines; i++) {
            add(new EmptyLine(0, 0));
        }
    }

    public void addSpacing(int lines, boolean movePointer) {
        if (movePointer) {
            for (int i = 0; i < lines; i++) {
                add(new EmptyLine(0, 0));
            }
        } else {
            for (int i = 0; i < lines; i++) {
                renderables.add(new EmptyLine(0, 0));
            }
        }
    }

    public List<Renderable> getRenderables() {
        return renderables;
    }
}
