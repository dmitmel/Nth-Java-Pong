package pong.game.screens;

import pong.game.graphics.common.GameScreen;
import pong.game.objects.Background;
import pong.game.objects.FPSCounter;
import pong.game.objects.gameplay.Ball;
import pong.game.objects.gameplay.Platform;
import pong.game.objects.gameplay.ScoreLabel;

public class GamePlayScreen extends GameScreen {
    public static final int ID = 1;

    public static final Background BACKGROUND = new Background();
    public static final Ball BALL = new Ball();
    public static final Platform FIRST_PLATFORM = new Platform(Platform.Type.FIRST_BOT_PLATFORM);
    public static final Platform SECOND_PLATFORM = new Platform(Platform.Type.SECOND_BOT_PLATFORM);
    public static final ScoreLabel SCORE_LABEL = new ScoreLabel();
    public static final FPSCounter FPS_COUNTER = new FPSCounter();

    public GamePlayScreen() {
        super(BACKGROUND, BALL, FIRST_PLATFORM, SECOND_PLATFORM, SCORE_LABEL, FPS_COUNTER);
    }

    @Override
    public int getID() {
        return ID;
    }
}
