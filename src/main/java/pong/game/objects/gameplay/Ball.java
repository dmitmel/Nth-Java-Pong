package pong.game.objects.gameplay;

import pong.game.Colors;
import pong.game.Pong;
import pong.game.graphics.common.Game;
import pong.game.graphics.common.GameObject;
import pong.game.graphics.common.Graphics;
import pong.game.screens.GamePlayScreen;
import pong.game.util.MoreMath;

import java.awt.*;

public class Ball extends GameObject {
    public static final Color BALL_COLOR = Colors.BLACK;
    public static final float BALL_DIAMETER = 15;
    public static final float BALL_RADIUS = BALL_DIAMETER / 2;

    public static final float DEFAULT_Y_SPEED = 0.5f;
    public static final float MAX_Y_SPEED = 1;

    public static final float DEFAULT_X_SPEED = 1;

    /** <b>Minimal distance from window's side to the nearest ball's
     * side</b> to say that ball is over the window's side. */
    public static final int MIN_DISTANCE_OVER_WINDOW = 20;

    public static final float MAX_DEVIATION_IF_BALL_HITS_CENTER = 0.3f;

    protected float xSpeed = MoreMath.randomBoolean() ? DEFAULT_X_SPEED : -DEFAULT_X_SPEED;
    protected float ySpeed = DEFAULT_Y_SPEED;

    public Ball() {
        super(Pong.WINDOW_WIDTH / 2 - BALL_RADIUS, Pong.WINDOW_HEIGHT / 2 - BALL_RADIUS, BALL_DIAMETER);
    }

    @Override
    public void render(Game gae, Graphics graphics) {
        graphics.setFill(BALL_COLOR);
        graphics.drawCircle(x, y, BALL_DIAMETER);
    }

    @Override
    public void updateLogic(Game game) {
        if (collidesWith(GamePlayScreen.FIRST_PLATFORM)) {
            xSpeed = -xSpeed;
            ySpeed = computeYSpeedAfterHittingPlatform(GamePlayScreen.FIRST_PLATFORM);
        } else if (collidesWith(GamePlayScreen.SECOND_PLATFORM)) {
            xSpeed = -xSpeed;
            ySpeed = computeYSpeedAfterHittingPlatform(GamePlayScreen.SECOND_PLATFORM);
        } else if (touchesWindowTop() || touchesWindowBottom()) {
            ySpeed = -ySpeed;
        }

        x += xSpeed;
        y += ySpeed;
    }

    /**
     * Computes {@link #ySpeed} after hitting platform. Uses this
     * scheme (numbers are ySpeeds):
     * <pre><code>
     * __
     *   | -1
     *   | -0.5
     *   | 0
     *   | 0.5
     * __| 1
     * </code></pre>
     */
    protected float computeYSpeedAfterHittingPlatform(Platform platform) {
        // Rounding this values to make deviation in ball's bounce. This makes game more interesting, especially in the
        // demo-mode (all platforms are bots)
        float roundedBallCenterY = Math.round(this.centerY());
        float roundedPlatformCenterY = Math.round(platform.centerY());

        if (roundedBallCenterY > roundedPlatformCenterY) {           // Ball is lower then platform
            float distanceToPlatformCenter = roundedBallCenterY - roundedPlatformCenterY;
            return MoreMath.map(distanceToPlatformCenter, 0, Platform.PLATFORM_HEIGHT / 2, 0, MAX_Y_SPEED);

        } else if (roundedBallCenterY < roundedPlatformCenterY) {    // Ball is higher than platform
            float distanceToPlatformCenter = roundedPlatformCenterY - roundedBallCenterY;
            return -(MoreMath.map(distanceToPlatformCenter, 0, Platform.PLATFORM_HEIGHT / 2, 0, MAX_Y_SPEED));

        } else {                                       // Ball is on the same level as platform
            // Some random to make game more interesting, especially in the demo-mode (all platforms are bots)
            return MoreMath.randomInRange(-MAX_DEVIATION_IF_BALL_HITS_CENTER, MAX_DEVIATION_IF_BALL_HITS_CENTER);
        }
    }

    protected boolean isOverLeftWindowSide() {
        return x + Ball.BALL_DIAMETER + MIN_DISTANCE_OVER_WINDOW <= 0;
    }

    protected boolean isOverRightWindowSide() {
        return x - MIN_DISTANCE_OVER_WINDOW >= Pong.WINDOW_WIDTH;
    }
}
