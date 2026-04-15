package com.daniel.game.layout;

import org.jline.utils.AttributedString;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FrameBufferTest {

    private List<AttributedString> frame(String... rows) {
        List<AttributedString> result = new ArrayList<>();
        for (String row : rows) {
            result.add(new AttributedString(row));
        }
        return result;
    }

    @Test
    public void getFrame_emptyBuffer() {
        FrameConstructor buffer = new FrameConstructor(5, 5);

        assertEquals(buffer.getFrame(),
                frame(
                        "     ",
                        "     ",
                        "     ",
                        "     ",
                        "     "
                )
        );
    }

    @Test
    public void drawLine_diagonal() {
        FrameConstructor buffer = new FrameConstructor(5, 5);
        buffer.drawLine('/', 0, 0, 4, 4);

        assertEquals(buffer.getFrame(),
                frame(
                        "/    ",
                        " /   ",
                        "  /  ",
                        "   / ",
                        "    /"
                )
        );
    }

    @Test
    public void drawHorizontalLine_basic() {
        FrameConstructor constructor = new FrameConstructor(5, 5);
        constructor.drawHorizontalLine('-', 0, 0, 3);

        assertEquals(constructor.getFrame(),
                frame(
                        "---- ",
                        "     ",
                        "     ",
                        "     ",
                        "     "
                )
        );
    }

    @Test
    public void drawVerticalLine_basic() {
        FrameConstructor constructor = new FrameConstructor(5, 5);
        constructor.drawVerticalLine('x', 2, 1, 3);

        assertEquals(constructor.getFrame(),
                frame(
                        "     ",
                        "  x  ",
                        "  x  ",
                        "  x  ",
                        "     "
                )
        );
    }

    @Test
    public void drawBox_smallBox() {
        FrameConstructor constructor = new FrameConstructor(5, 5);
        constructor.drawBox(1, 1, 3, 3);

        assertEquals(constructor.getFrame(),
                frame(
                        "     ",
                        " ┏━┓ ",
                        " ┃ ┃ ",
                        " ┗━┛ ",
                        "     "
                )
        );
    }

    @Test
    public void drawBox_largerBox() {
        FrameConstructor constructor = new FrameConstructor(5, 5);
        constructor.drawBox(1, 1, 4, 4);

        assertEquals(constructor.getFrame(),
                frame(
                        "     ",
                        " ┏━━┓",
                        " ┃  ┃",
                        " ┃  ┃",
                        " ┗━━┛"
                )
        );
    }

    @Test
    public void drawBox_partialOutOfBounds() {
        FrameConstructor constructor = new FrameConstructor(5, 5);
        constructor.drawBox(1, 4, 5, 5);

        assertEquals(constructor.getFrame(),
                frame(
                        "     ",
                        "     ",
                        "     ",
                        "     ",
                        " ┏━━━"
                )
        );
    }

    @Test
    public void drawRect_partialOutOfBounds() {
        FrameConstructor constructor = new FrameConstructor(5, 5);
        constructor.drawRect(1, 4, 5, 5);

        assertEquals(constructor.getFrame(),
                frame(
                        "     ",
                        "     ",
                        "     ",
                        "     ",
                        " ┏━━━"
                )
        );
    }

    @Test
    public void drawRect_fullScreen() {
        FrameConstructor constructor = new FrameConstructor(5, 5);
        constructor.drawRect(0, 0, 5, 5);

        assertEquals(constructor.getFrame(),
                frame(
                        "┏━━━┓",
                        "┃   ┃",
                        "┃   ┃",
                        "┃   ┃",
                        "┗━━━┛"
                )
        );
    }

    @Test
    public void drawText_simple() {
        FrameConstructor constructor = new FrameConstructor(5, 5);
        constructor.drawText("amogus", 0, 0);

        assertEquals(constructor.getFrame(),
                frame(
                        "amogu",
                        "     ",
                        "     ",
                        "     ",
                        "     "
                )
        );
    }
}