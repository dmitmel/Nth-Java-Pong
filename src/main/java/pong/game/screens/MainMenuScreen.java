package pong.game.screens;

import pong.game.graphics.common.GameScreen;
import pong.game.objects.Background;
import pong.game.objects.FPSCounter;
import pong.game.objects.demo.DemoBall;
import pong.game.objects.demo.DemoPlatform;
import pong.game.objects.gameplay.Platform;

public class MainMenuScreen extends GameScreen {
    public static final int ID = 0;

    public static final Background BACKGROUND = new Background();
    public static final DemoBall BALL = new DemoBall();
    public static final DemoPlatform FIRST_PLATFORM = new DemoPlatform(Platform.Type.FIRST_BOT_PLATFORM);
    public static final DemoPlatform SECOND_PLATFORM = new DemoPlatform(Platform.Type.SECOND_BOT_PLATFORM);
    public static final FPSCounter FPS_COUNTER = new FPSCounter();

    public MainMenuScreen() {
        super(BACKGROUND, BALL, FIRST_PLATFORM, SECOND_PLATFORM, FPS_COUNTER);
    }

    @Override
    public int getID() {
        return ID;
    }
}
