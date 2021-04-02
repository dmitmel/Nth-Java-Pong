package pong.game;

import pong.game.graphics.common.FontUtils;
import pong.game.graphics.common.Game;
import pong.game.screens.GamePlayScreen;
import pong.game.screens.MainMenuScreen;

public class Pong extends Game {
    public static final String WINDOW_TITLE = "Pong";

    public static final boolean FULLSCREEN_MODE = false;
    public static final int WINDOW_WIDTH = 640;
    public static final int WINDOW_HEIGHT = 480;

    public static final java.awt.Font NORMAL_FONT_MODEL = FontUtils.fromTrueTypeInputStream(
            Pong.class.getResourceAsStream("/pong/game/fonts/SF_Cartoonist_Hand.ttf"));
    public static final java.awt.Font BOLD_FONT_MODEL = FontUtils.fromTrueTypeInputStream(
            Pong.class.getResourceAsStream("/pong/game/fonts/SF_Cartoonist_Hand_Bold.ttf"));

    public static void main(String[] args) {
        Game.setGraphicLibraryAdapter("pong.game.graphics.adapters.slick.SlickAdapter");
        launchGameWithArgs(new Pong(), args);
    }

    public Pong() {
        super(WINDOW_TITLE);
    }

    @Override
    public void setupGame(Game game) {
        addScreen(new MainMenuScreen());
        addScreen(new GamePlayScreen());
        setActiveGameScreenID(1);
    }
}
