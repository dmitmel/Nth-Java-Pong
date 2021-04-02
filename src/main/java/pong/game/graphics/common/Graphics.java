package pong.game.graphics.common;

import pong.game.graphics.adapters.GraphicLibraryAdapter;
import pong.game.graphics.adapters.GraphicLibraryAdapterFactory;

import java.awt.*;

public class Graphics {
    private GraphicLibraryAdapter graphicLibraryAdapter = GraphicLibraryAdapterFactory.getAdapterInstance();


    public void setFill(Color color) {
        graphicLibraryAdapter.setFill(color);
    }

    public void setStroke(Color color) {
        graphicLibraryAdapter.setStoke(color);
    }

    public void setLineWidth(float lineWidth) {
        graphicLibraryAdapter.setLineWidth(lineWidth);
    }

    public void setFont(Font font) {
        graphicLibraryAdapter.setFont(font);
    }


    public void drawEllipse(float x, float y, float width, float height) {
        graphicLibraryAdapter.drawEllipse(x, y, width, height);
    }

    public void drawCircle(float x, float y, float diameter) {
        drawEllipse(x, y, diameter, diameter);
    }


    public void drawRect(float x, float y, float width, float height) {
        graphicLibraryAdapter.drawRect(x, y, width, height);
    }

    public void drawSquare(float x, float y, float size) {
        drawRect(x, y, size, size);
    }


    public void drawText(String text, float x, float y) {
        graphicLibraryAdapter.drawText(text, x, y);
    }

    public void drawLine(float x1, float y1, float x2, float y2) {
        graphicLibraryAdapter.drawLine(x1, y1, x2, y2);
    }
}
