package com.daniel.game.ui;

import com.daniel.game.layout.FrameConstructor;
import org.jline.utils.AttributedString;

public class EmptyLine extends UIComponent {

    @Override
    public AttributedString getAttrString() {
        return new AttributedString(" ");
    }

    @Override
    public void render(FrameConstructor frame) {
    }
}
