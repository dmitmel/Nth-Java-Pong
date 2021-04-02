package pong.game.graphics.adapters;

import pong.game.graphics.common.Game;

import java.awt.*;

public interface GraphicLibraryAdapter {
    void initInGame(Game game);

    void startGame();
    void stopGame();

    int getFPS();

    ///////////////////////////// INPUT HANDLING METHODS /////////////////////////////
    boolean isKeyDown(int keyCode);

    ///////////////////////////// WINDOW ACCESS METHODS ////////////////////////////
    void setWindowSize(int width, int height);
    void setWindowWidth(int width);
    int getWindowWidth();
    void setWindowHeight(int height);
    int getWindowHeight();
    void setFullscreenMode(boolean fullscreenMode);
    boolean isFullscreen();
    
    ///////////////////////////// SCREEN ACCESS METHODS ////////////////////////////
    int getScreenWidth();
    int getScreenHeight();

    ///////////////////////////// DRAWING ATTRIBUTES METHODS /////////////////////////////
    void setFill(Color color);
    void setLineWidth(float lineWidth);
    void setFont(Font font);
    void setStoke(Color color);

    ///////////////////////////// DRAWING METHODS /////////////////////////////
    void drawRect(float x, float y, float width, float height);
    void drawEllipse(float x, float y, float width, float height);
    void drawText(String text, float x, float y);
    void drawLine(float x1, float y1, float x2, float y2);
}
