package pong.game.graphics.common;

import java.util.Arrays;
import java.util.List;

public abstract class GameScreen {
    public final GameObject background;
    public final List<GameObject> childrenGameObjects;

    public GameScreen(GameObject background, GameObject... childrenGameObjects) {
        this.background = background;
        this.childrenGameObjects = Arrays.asList(childrenGameObjects);
    }

    public abstract int getID();

    public void render(Game container, Graphics graphics) {
        background.renderIfVisible(container, graphics);
        for (GameObject gameObject : childrenGameObjects)
            gameObject.renderIfVisible(container, graphics);
    }

    public void updateLogic(Game container) {
        background.updateLogicIfActive(container);
        for (GameObject gameObject : childrenGameObjects)
            gameObject.updateLogicIfActive(container);
    }
}
