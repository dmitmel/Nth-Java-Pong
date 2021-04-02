package pong.game.graphics.adapters.slick;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import pong.game.graphics.adapters.GraphicLibraryAdapter;
import pong.game.graphics.adapters.GraphicLibraryException;
import pong.game.graphics.common.Game;

import java.awt.*;

public class SlickAdapter implements GraphicLibraryAdapter {
    private AppGameContainer slickGameContainer;
    private SlickGraphics slickGraphics = new SlickGraphics();

    @Override
    public void initInGame(Game commonGame) {
        try {
            SlickGame slickGame = new SlickGame(commonGame);
            slickGameContainer = new AppGameContainer(slickGame);
            slickGameContainer.setShowFPS(false);     // Removing built-in FPS counter. We need clean window!
        } catch (SlickException e) {
            throw new GraphicLibraryException(e);
        }
    }

    @Override
    public void startGame() {
        try {
            slickGameContainer.start();
        } catch (SlickException e) {
            throw new GraphicLibraryException(e);
        }
    }

    @Override
    public void stopGame() {
        slickGameContainer.destroy();
    }

    @Override
    public int getFPS() {
        return slickGameContainer.getFPS();
    }

    ///////////////////////////// INPUT HANDLING METHODS /////////////////////////////
    @Override
    public boolean isKeyDown(int keyCode) {
        return slickGameContainer.getInput().isKeyDown(keyCode);
    }

    ///////////////////////////// WINDOW ACCESS METHODS ////////////////////////////
    @Override
    public void setWindowSize(int width, int height) {
        setWindowWidth(width);
        setWindowHeight(height);
    }
    
    @Override
    public void setWindowWidth(int width) {
        try {
            slickGameContainer.setDisplayMode(width, getScreenHeight(), isFullscreen());
        } catch (SlickException e) {
            throw new GraphicLibraryException(e);
        }
    }
    
    @Override
    public int getWindowWidth() {
        return slickGameContainer.getWidth();
    }
    
    @Override
    public void setWindowHeight(int height) {
        try {
            slickGameContainer.setDisplayMode(getWindowHeight(), height, isFullscreen());
        } catch (SlickException e) {
            throw new GraphicLibraryException(e);
        }
    }
    
    @Override
    public int getWindowHeight() {
        return slickGameContainer.getHeight();
    }
    
    @Override
    public void setFullscreenMode(boolean fullscreenMode) {
        try {
            slickGameContainer.setFullscreen(fullscreenMode);
        } catch (SlickException e) {
            throw new GraphicLibraryException(e);
        }
    }
    
    @Override
    public boolean isFullscreen() {
        return slickGameContainer.isFullscreen();
    }
    
    ///////////////////////////// WINDOW ACCESS METHODS ////////////////////////////
    @Override
    public int getScreenWidth() {
        return slickGameContainer.getScreenWidth();
    }

    @Override
    public int getScreenHeight() {
        return slickGameContainer.getScreenHeight();
    }

    ///////////////////////////// DRAWING ATTRIBUTES METHODS /////////////////////////////
    @Override
    public void setFill(Color color) {
        slickGraphics.setFill(color);
    }

    @Override
    public void setStoke(Color color) {
        slickGraphics.setStroke(color);
    }

    public void setLineWidth(float lineWidth) {
        slickGraphics.setLineWidth(lineWidth);
    }

    public void setFont(Font font) {
        slickGraphics.setFont(font);
    }

    ///////////////////////////// DRAWING METHODS /////////////////////////////
    public void drawRect(float x, float y, float width, float height) {
        slickGraphics.drawRect(x, y, width, height);
    }

    public void drawEllipse(float x, float y, float width, float height) {
        slickGraphics.drawEllipse(x, y, width, height);
    }

    public void drawText(String text, float x, float y) {
        slickGraphics.drawText(text, x, y);
    }

    public void drawLine(float x1, float y1, float x2, float y2) {
        slickGraphics.drawLine(x1, y1, x2, y2);
    }
}
