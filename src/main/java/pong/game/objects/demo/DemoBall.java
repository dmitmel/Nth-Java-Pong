package pong.game.objects.demo;

import pong.game.graphics.common.Game;
import pong.game.objects.gameplay.Ball;
import pong.game.screens.MainMenuScreen;

public class DemoBall extends Ball {

    @Override
    public void updateLogic(Game game) {
        if (isOverLeftWindowSide() || isOverRightWindowSide()) {
            throwBallAgain();
            return;
        }

        if (collidesWith(MainMenuScreen.FIRST_PLATFORM)) {
            xSpeed = -xSpeed;
            ySpeed = computeYSpeedAfterHittingPlatform(MainMenuScreen.FIRST_PLATFORM);
        } else if (collidesWith(MainMenuScreen.SECOND_PLATFORM)) {
            xSpeed = -xSpeed;
            ySpeed = computeYSpeedAfterHittingPlatform(MainMenuScreen.SECOND_PLATFORM);
        } else if (touchesWindowTop() || touchesWindowBottom()) {
            ySpeed = -ySpeed;
        }

        x += xSpeed;
        y += ySpeed;
    }

    private void throwBallAgain() {
        xSpeed = -xSpeed;
        resetX();
        resetY();
        ySpeed = Ball.DEFAULT_Y_SPEED;
    }
}
