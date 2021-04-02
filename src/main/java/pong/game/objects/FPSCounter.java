package pong.game.objects;

import pong.game.Colors;
import pong.game.Pong;
import pong.game.graphics.common.FontUtils;
import pong.game.graphics.common.Game;
import pong.game.graphics.common.GameObject;
import pong.game.graphics.common.Graphics;

import java.awt.*;

public class FPSCounter extends GameObject {
    public static final Font FONT = Pong.BOLD_FONT_MODEL.deriveFont(24f);   // Making custom bold font with size 24px

    public static final float TEXT_X = 10;
    public static final float TEXT_Y = 10;

    public static final Color TEXT_COLOR = Colors.INK_COLOR;

    public FPSCounter() {
        super(TEXT_X, TEXT_Y, -1, FontUtils.getLineHeight(FONT));
    }

    @Override
    public void render(Game game, Graphics graphics) {
        String fpsString = "FPS: " + game.getFPS();
        width = FontUtils.getStringWidth(FONT, fpsString);

        graphics.setFill(TEXT_COLOR);
        graphics.setFont(FONT);
        graphics.drawText(fpsString, TEXT_X, TEXT_Y);
    }

    @Override
    public void updateLogic(Game game
    ) {

    }
}
