package pong.game.graphics.adapters.slick;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import pong.game.graphics.common.GameScreen;

class SlickGame extends BasicGame {
    private pong.game.graphics.common.Game game;

    public SlickGame(pong.game.graphics.common.Game commonGame) {
        super(commonGame.windowTitle);
        this.game = commonGame;
    }

    @Override
    public void init(GameContainer container) {}

    @Override
    public void update(GameContainer container, int delta) {
        GameScreen activeGameScreen = game.activeGameScreen;
        activeGameScreen.updateLogic(game);
    }

    @Override
    public void render(GameContainer container, Graphics g) {
        GameScreen activeGameScreen = game.activeGameScreen;
        activeGameScreen.render(game, new pong.game.graphics.common.Graphics());
    }
}
