package com.daniel.game.ui;

import org.jline.utils.AttributedString;

public class EmptyLine extends UIComponent {

    @Override
    public AttributedString getAttrString() {
        return new AttributedString(" ");
    }
}
