package pong.game.objects.gameplay;

import pong.game.Colors;
import pong.game.Pong;
import pong.game.graphics.common.Game;
import pong.game.graphics.common.GameObject;
import pong.game.graphics.common.Graphics;
import pong.game.graphics.common.Input;
import pong.game.screens.GamePlayScreen;

import java.awt.*;

public class Platform extends GameObject {
    public static final Color PLATFORM_COLOR = Colors.INK_COLOR;

    public static final float PLATFORM_WIDTH = 10;
    public static final float PLATFORM_HEIGHT = 60;

    public static final float PLATFORM_MARGIN_FROM_SIDE = 15;

    public static final float PLATFORM_MOVE_SPEED = 0.7f;

    private int moveUpKeyCode = -1;
    private int moveDownKeyCode = -1;
    private boolean player = false;

    public Platform(Platform.Type type) {
        super(0, Pong.WINDOW_HEIGHT / 2 - PLATFORM_HEIGHT / 2, PLATFORM_WIDTH, PLATFORM_HEIGHT);

        switch (type) {
            case FIRST_PLAYER_PLATFORM:
                moveUpKeyCode = Input.KEY_W;
                moveDownKeyCode = Input.KEY_S;
                player = true;
            case FIRST_BOT_PLATFORM:
                x = PLATFORM_MARGIN_FROM_SIDE;
                break;

            case SECOND_PLAYER_PLATFORM:
                moveUpKeyCode = Input.KEY_UP;
                moveDownKeyCode = Input.KEY_DOWN;
                player = true;
            case SECOND_BOT_PLATFORM:
                x = Pong.WINDOW_WIDTH - PLATFORM_MARGIN_FROM_SIDE - PLATFORM_WIDTH;
                break;
        }
    }

    @Override
    public void render(Game game, Graphics graphics) {
        graphics.setFill(PLATFORM_COLOR);
        graphics.drawRect(x, y, PLATFORM_WIDTH, PLATFORM_HEIGHT);
    }

    @Override
    public void updateLogic(Game game) {
        if (player) {
            moveInPlayerModeUsingInput(game.getInput());
        } else {
            moveInBotMode();
        }
    }

    protected void moveInBotMode() {
        float centerYDifference = centerYDifferenceWith(GamePlayScreen.BALL);
        if (centerYDifference < 0 && canIncrementX())
            y += PLATFORM_MOVE_SPEED;
        if (centerYDifference > 0 && canDecrementY())
            y -= PLATFORM_MOVE_SPEED;
    }

    private void moveInPlayerModeUsingInput(Input input) {
        if (input.isKeyDown(moveUpKeyCode) && canDecrementY())
            y -= PLATFORM_MOVE_SPEED;
        else if (input.isKeyDown(moveDownKeyCode) && canIncrementX())
            y += PLATFORM_MOVE_SPEED;
    }

    protected boolean canDecrementY() { return y >= 0; }
    protected boolean canIncrementX() { return y + PLATFORM_HEIGHT <= Pong.WINDOW_HEIGHT; }

    public enum Type {
        FIRST_PLAYER_PLATFORM, SECOND_PLAYER_PLATFORM, FIRST_BOT_PLATFORM, SECOND_BOT_PLATFORM
    }
}
