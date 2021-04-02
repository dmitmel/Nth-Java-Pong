package pong.game.graphics.common;

import pong.game.graphics.adapters.GraphicLibraryAdapter;
import pong.game.graphics.adapters.GraphicLibraryAdapterFactory;

public class Input {
    // Decimal key-codes
    public static final int KEY_W = 17;
    public static final int KEY_S = 31;
    public static final int KEY_UP = 200;
    public static final int KEY_DOWN = 208;

    private final GraphicLibraryAdapter adapter = GraphicLibraryAdapterFactory.getAdapterInstance();

    public boolean isKeyDown(int keyCode) {
        return adapter.isKeyDown(keyCode);
    }
}
