package com.daniel.game.layout;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;

import java.util.ArrayList;
import java.util.List;

public class FrameConstructor {
    private final FrameCell[][] grid;

    public FrameConstructor(int size_x, int size_y) {
        this.grid = new FrameCell[size_x][size_y];
        for (int i = 0; i < size_y; i++) {
            for (int j = 0; j < size_x; j++) {
                grid[i][j] = new FrameCell(' ', AttributedStyle.DEFAULT);
            }
        }
    }

    public List<AttributedString> getFrame() {
        List<AttributedString> frame = new ArrayList<>();
        for (FrameCell[] row: grid) {
            AttributedStringBuilder builder = new AttributedStringBuilder();
            for (FrameCell cell: row) {
                builder.style(cell.style).append(cell.c);
            }
            frame.add(builder.toAttributedString());
        }
        return frame;
    }

    private void drawPoint(char c, int x, int y) {
        if (y>= 0 && y < grid.length &&
                x >= 0 && x < grid[0].length) {
            grid[y][x] = new FrameCell(c, AttributedStyle.DEFAULT);
        }
    }

    private void drawPoint(char c, AttributedStyle style, int x, int y) {
        if (y>= 0 && y < grid.length &&
                x >= 0 && x < grid[0].length) {
            grid[y][x] = new FrameCell(c, style);
        }
    }

    public void drawLine(
            char charToPrint,
            int start_x,
            int start_y,
            int end_x,
            int end_y
    ) {
        // implement Bresenham Line algorithm.

        int dx = Math.abs(end_x - start_x);
        int dy = Math.abs(end_y - start_y);

        int sx = (start_x < end_x) ? 1 : -1;
        int sy = (start_y < end_y) ? 1 : -1;

        int err = dx - dy;

        while (true) {
            drawPoint(charToPrint, start_x, start_y);

            if (start_x == end_x && start_y == end_y) break;

            int e2 = 2 * err;

            if (e2 > -dy) {
                err -= dy;
                start_x += sx;
            }

            if (e2 < dx) {
                err += dx;
                start_y += sy;
            }
        }
    }

    public void drawLine(
            char charToPrint,
            AttributedStyle style,
            int start_x,
            int start_y,
            int end_x,
            int end_y
    ) {
        // implement Bresenham Line algorithm.

        int dx = Math.abs(end_x - start_x);
        int dy = Math.abs(end_y - start_y);

        int sx = (start_x < end_x) ? 1 : -1;
        int sy = (start_y < end_y) ? 1 : -1;

        int err = dx - dy;

        while (true) {
            drawPoint(charToPrint, style, start_x, start_y);

            if (start_x == end_x && start_y == end_y) break;

            int e2 = 2 * err;

            if (e2 > -dy) {
                err -= dy;
                start_x += sx;
            }

            if (e2 < dx) {
                err += dx;
                start_y += sy;
            }
        }
    }

    public void drawHorizontalLine(
            char c,
            int y,
            int start_x,
            int end_x
    ) {
        while(true) {
            drawPoint(c, start_x, y);

            if (start_x == end_x) break;

            start_x++;
        }
    }

    public void drawHorizontalLine(
            char c,
            AttributedStyle style,
            int y,
            int start_x,
            int end_x
    ) {
        while(true) {
            drawPoint(c, style, start_x, y);

            if (start_x == end_x) break;

            start_x++;
        }
    }

    public void drawVerticalLine(
            char c,
            int x,
            int start_y,
            int end_y
    ) {
        while(true) {
            drawPoint(c, x, start_y);

            if (start_y == end_y) break;

            start_y++;
        }
    }

    public void drawVerticalLine(
            char c,
            AttributedStyle style,
            int x,
            int start_y,
            int end_y
    ) {
        while(true) {
            drawPoint(c, style, x, start_y);

            if (start_y == end_y) break;

            start_y++;
        }
    }

    public void drawBox(
            int start_x,
            int start_y,
            int end_x,
            int end_y
    ) {
        drawHorizontalLine('━', start_y, start_x, end_x);
        drawHorizontalLine('━', end_y, start_x, end_x);
        drawVerticalLine('┃', start_x, start_y, end_y);
        drawVerticalLine('┃', end_x, start_y, end_y);

        drawPoint('┏', start_x, start_y);
        drawPoint('┓', end_x, start_y);
        drawPoint('┗', start_x, end_y);
        drawPoint('┛', end_x, end_y);
    }

    public void drawBox(
            AttributedStyle style,
            int start_x,
            int start_y,
            int end_x,
            int end_y
    ) {
        drawHorizontalLine('━', style, start_y, start_x, end_x);
        drawHorizontalLine('━', style, end_y, start_x, end_x);
        drawVerticalLine('┃', style, start_x, start_y, end_y);
        drawVerticalLine('┃', style, end_x, start_y, end_y);

        drawPoint('┏', style, start_x, start_y);
        drawPoint('┓', style, end_x, start_y);
        drawPoint('┗', style, start_x, end_y);
        drawPoint('┛', style, end_x, end_y);
    }

    public void drawRect(
            int x,
            int y,
            int l,
            int h
    ) {
        int end_x = x + l - 1;
        int end_y = y + h - 1;

        drawBox(x, y, end_x, end_y);
    }

    public void drawRect(
            AttributedStyle style,
            int x,
            int y,
            int l,
            int h
    ) {
        int end_x = x + l - 1;
        int end_y = y + h - 1;

        drawBox(style, x, y, end_x, end_y);
    }

    public void drawText(String text, int x, int y) {
        for (char character: text.toCharArray()) {
            drawPoint(character, x, y);
            x++;
        }
    }

    public void drawText(String text, AttributedStyle style, int x, int y) {
        for (char character: text.toCharArray()) {
            drawPoint(character, style, x, y);
            x++;
        }
    }
}
