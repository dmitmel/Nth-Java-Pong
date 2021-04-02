package pong.game.graphics.common;

import pong.game.Pong;

import java.util.function.Consumer;

public abstract class GameObject {
    public float x;
    public float y;

    public final float initialX;
    public final float initialY;

    public float width;
    public float height;

    /** Sets visibility for this object. If object isn't visible,
     * logic will be updated, but object won't be drawn. */
    public boolean visible = true;
    /** Says if this object is active. If object isn't active,
     * logic won't be updated, but object will be drawn. */
    public boolean active = true;

    public GameObject(float x, float y, float size) {
        this(x, y, size, size);
    }

    public GameObject(float x, float y, float width, float height) {
        this.initialX = this.x = x;
        this.initialY = this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean collidesWith(GameObject other) {
        return x + width >= other.x &&          // Checking if the right side collides with other left side
                other.x + other.width >= x &&   // Checking if the left side collides with other right side
                y + height >= other.y &&        // Checking if the bottom side collides with other top side
                other.y + other.height >= y;    // Checking if the top side collides with other bottom side
    }

    protected boolean touchesWindowRight() { return x + width >= Pong.WINDOW_WIDTH; }
    protected boolean touchesWindowLeft() { return x <= 0; }
    protected boolean touchesWindowBottom() { return y + height >= Pong.WINDOW_HEIGHT; }
    protected boolean touchesWindowTop() { return y <= 0; }

    public float centerX() { return x + width / 2; }
    public float centerY() { return y + height / 2; }

    public float centerXDifferenceWith(GameObject other) {
        return this.centerX() - other.centerX();
    }
    public float centerYDifferenceWith(GameObject other) {
        return this.centerY() - other.centerY();
    }

    public void resetX() { x = initialX; }
    public void resetY() { y = initialY; }

    public abstract void render(Game game, Graphics graphics);
    public abstract void updateLogic(Game game);

    public void renderIfVisible(Game game, Graphics graphics) {
        if (visible)
            render(game, graphics);
    }

    public void accessIfVisible(Consumer<GameObject> consumer) {
        if (visible)
            consumer.accept(this);
    }

    public void updateLogicIfActive(Game game) {
        if (active)
            updateLogic(game);
    }

    public void accessIfActive(Consumer<GameObject> consumer) {
        if (active)
            consumer.accept(this);
    }
}
