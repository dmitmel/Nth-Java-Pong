package pong.game.objects;

import pong.game.Colors;
import pong.game.Pong;
import pong.game.graphics.common.FontUtils;
import pong.game.graphics.common.Game;
import pong.game.graphics.common.GameObject;
import pong.game.graphics.common.Graphics;

import java.awt.*;

public class Background extends GameObject {
    public static final Font FONT = Pong.NORMAL_FONT_MODEL.deriveFont(200f);  // Making custom bold font with size 200px

    public static final String TEXT = "PONG";
    public static final float TEXT_X = Pong.WINDOW_WIDTH / 2 - FontUtils.getStringWidth(FONT, TEXT) / 2;
    public static final float TEXT_Y = Pong.WINDOW_HEIGHT / 2 - FontUtils.getLineHeight(FONT) / 2;

    public static final Color TEXT_COLOR = Colors.INK_COLOR;

    public static final Color BACKGROUND_COLOR = Colors.WHITE;

    // Constants for drawing copybook-like background
    public static final float DISTANCE_BETWEEN_LINES_OF_SQUARES = 15;
    public static final float COPYBOOK_SQUARES_LINE_WIDTH = 1;
    public static final float RED_LINE_MARGIN_FROM_LEFT_SIDE = DISTANCE_BETWEEN_LINES_OF_SQUARES * 5;
    public static final float RED_LINE_X = Pong.WINDOW_WIDTH - RED_LINE_MARGIN_FROM_LEFT_SIDE;
    public static final float RED_LINE_WIDTH = 2;

    public Background() {
        super(0, 0, Pong.WINDOW_WIDTH, Pong.WINDOW_HEIGHT);
    }

    @Override
    public void render(Game game, Graphics graphics) {
        clearBackground(graphics);
        drawCopybookSheet(graphics);
        drawBackgroundText(graphics);
    }

    private void drawBackgroundText(Graphics graphics) {
        graphics.setFill(TEXT_COLOR);
        graphics.setFont(FONT);
        graphics.drawText(TEXT, TEXT_X, TEXT_Y);
    }

    private void drawCopybookSheet(Graphics graphics) {
        graphics.setLineWidth(COPYBOOK_SQUARES_LINE_WIDTH);
        graphics.setStroke(Colors.COPYBOOK_SQUARES_COLOR);

        // Drawing vertical lines
        for (float x = DISTANCE_BETWEEN_LINES_OF_SQUARES;    // Making offset to avoid drawing drawLine at y: 0
             x < Pong.WINDOW_WIDTH; x += DISTANCE_BETWEEN_LINES_OF_SQUARES)
            graphics.drawLine(x, 0, x, Pong.WINDOW_HEIGHT);
        // Drawing horizontal lines
        for (float y = DISTANCE_BETWEEN_LINES_OF_SQUARES;    // Making offset to avoid drawing drawLine at x: 0
             y < Pong.WINDOW_WIDTH; y += DISTANCE_BETWEEN_LINES_OF_SQUARES)
            graphics.drawLine(0, y, Pong.WINDOW_WIDTH, y);

        graphics.setStroke(Colors.COPYBOOK_RED_LINE_COLOR);
        graphics.setLineWidth(RED_LINE_WIDTH);
        graphics.drawLine(RED_LINE_X, 0, RED_LINE_X, Pong.WINDOW_HEIGHT);
    }

    private void clearBackground(Graphics graphics) {
        graphics.setFill(BACKGROUND_COLOR);
        graphics.drawRect(0, 0, Pong.WINDOW_WIDTH, Pong.WINDOW_HEIGHT);
    }

    @Override
    public void updateLogic(Game game) {}
}
