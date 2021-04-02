package pong.game.graphics.common;

import pong.game.graphics.adapters.GraphicLibraryAdapter;
import pong.game.graphics.adapters.GraphicLibraryAdapterFactory;

import java.util.ArrayList;

public abstract class Game {
    private static GraphicLibraryAdapter graphicLibraryAdapter;
    
    public final String windowTitle;
    private String[] args;
    public ArrayList<GameScreen> gameScreens = new ArrayList<>(0);
    public GameScreen activeGameScreen;
    
    public Game(String windowTitle) {
        this.windowTitle = windowTitle;
    }
    
    public static void launchGameWithArgs(Game game, String... args) {
        try {
            game.args = args;
            game.setupGame(game);
            graphicLibraryAdapter.initInGame(game);
            game.start();
        } catch (Exception e) {
            e.printStackTrace();
            game.destroy();
        }
    }

    public abstract void setupGame(Game game);

    protected void addScreen(GameScreen newGameScreen) {
        for (GameScreen gs : gameScreens)
            if (gs.getID() == newGameScreen.getID())
                throw new IllegalArgumentException(
                        String.format("game screens list contains ID %d of new screen", newGameScreen.getID()));
        gameScreens.add(newGameScreen);
    }

    protected void addScreens(GameScreen... gameScreens) {
        for (GameScreen gameScreen : gameScreens)
            addScreen(gameScreen);
    }

    protected void addScreens(Iterable<GameScreen> gameScreensCollection) {
        gameScreensCollection.forEach(this::addScreen);
    }

    public void setActiveGameScreenID(int id) {
        for (GameScreen gs : gameScreens) {
            if (gs.getID() == id) {
                activeGameScreen = gs;
                return;
            }
        }

        throw new IllegalArgumentException(String.format("no such game screen ID %d", id));
    }
    
    public static void setGraphicLibraryAdapter(String adapterClassName) {
        GraphicLibraryAdapterFactory.currentAdapterClassName = adapterClassName;
        graphicLibraryAdapter = GraphicLibraryAdapterFactory.getAdapterInstance();
    }
    
    public void setDisplayMode(int windowWidth, int windowHeight, boolean fullscreenMode) {
        graphicLibraryAdapter.setWindowSize(windowWidth, windowHeight);
    }
    
    public void start() {
        if (gameScreens.isEmpty())
            throw new IllegalStateException("game must contain at least 1 GameScreen");
        graphicLibraryAdapter.startGame();
    }
    
    public void destroy() {
        if (graphicLibraryAdapter != null)
            graphicLibraryAdapter.stopGame();
    }
    
    public Input getInput() {
        return new Input();
    }
    
    public int getFPS() {
        return graphicLibraryAdapter.getFPS();
    }
    
    public int getScreenWidth() {
        return graphicLibraryAdapter.getScreenWidth();
    }
    
    public int getScreenHeight() {
        return graphicLibraryAdapter.getScreenHeight();
    }

    public void render(Game game, Graphics graphics) {
        activeGameScreen.render(game, graphics);
    }
}
