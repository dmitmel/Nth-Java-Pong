package pong.game.objects.demo;

import pong.game.objects.gameplay.Platform;
import pong.game.screens.MainMenuScreen;

public class DemoPlatform extends Platform {
    public DemoPlatform(Type type) {
        super(filterPlatformType(type));
    }

    private static Type filterPlatformType(Type type) {
        if (type == Type.FIRST_BOT_PLATFORM || type == Type.SECOND_BOT_PLATFORM)
            return type;
        else
            throw new IllegalArgumentException("platform isn\'t bot");
    }

    @Override
    protected void moveInBotMode() {
        float centerYDifference = centerYDifferenceWith(MainMenuScreen.BALL);
        if (centerYDifference < 0 && canIncrementX())
            y += PLATFORM_MOVE_SPEED;
        if (centerYDifference > 0 && canDecrementY())
            y -= PLATFORM_MOVE_SPEED;
    }
}
