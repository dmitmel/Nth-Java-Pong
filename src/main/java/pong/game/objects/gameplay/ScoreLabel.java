package pong.game.objects.gameplay;

import pong.game.Colors;
import pong.game.Pong;
import pong.game.graphics.common.FontUtils;
import pong.game.graphics.common.Game;
import pong.game.graphics.common.GameObject;
import pong.game.graphics.common.Graphics;
import pong.game.screens.GamePlayScreen;

import java.awt.*;

public class ScoreLabel extends GameObject {
    public static final Font FONT = Pong.BOLD_FONT_MODEL.deriveFont(72f);   // Making custom bold font with size 72px

    public static final float TEXT_Y = 20;

    public static final Color TEXT_COLOR = Colors.INK_COLOR;

    private int firstPlayerScore = 0;
    private int secondPlayerScore = 0;

    public ScoreLabel() {
        super(-1, TEXT_Y, -1, FontUtils.getLineHeight(FONT));
    }

    @Override
    public void render(Game game, Graphics graphics) {
        String scoreString = String.format("%2d : %-2d", firstPlayerScore, secondPlayerScore);

        width = FontUtils.getStringWidth(FONT, scoreString);
        x = Pong.WINDOW_WIDTH / 2 - width / 2;

        graphics.setFont(FONT);
        graphics.setFill(TEXT_COLOR);
        graphics.drawText(scoreString, x, TEXT_Y);
    }

    @Override
    public void updateLogic(Game gamee) {
        final Ball ball = GamePlayScreen.BALL;

        if (ball.isOverLeftWindowSide()) {
            secondPlayerScore++;
            throwBallAgain();
        } else if (ball.isOverRightWindowSide()) {
            firstPlayerScore++;
            throwBallAgain();
        }
    }

    private void throwBallAgain() {
        final Ball ball = GamePlayScreen.BALL;

        ball.xSpeed = -ball.xSpeed;
        ball.resetX();
        ball.resetY();
        ball.ySpeed = Ball.DEFAULT_Y_SPEED;
    }
}
