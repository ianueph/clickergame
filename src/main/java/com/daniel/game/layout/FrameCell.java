package com.daniel.game.layout;

import org.jline.utils.AttributedStyle;

class FrameCell {
    char c;
    AttributedStyle style;

    FrameCell(char c, AttributedStyle style) {
        this.c = c;
        this.style = style;
    }
}
