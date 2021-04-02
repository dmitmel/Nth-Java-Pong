package pong.game.graphics.adapters.slick;

import org.newdawn.slick.Graphics;
import pong.game.graphics.common.FontUtils;

import java.awt.*;

class SlickGraphics {
    private org.newdawn.slick.Graphics graphics = new Graphics();

    /** Fill color for shapes. Default fill is black color. */
    private org.newdawn.slick.Color fill = slickColorFromAWTColor(new java.awt.Color(0));
    /** Stroke color for shapes. Default stroke is fully transparent
     * black color. */
    private org.newdawn.slick.Color stroke = slickColorFromAWTColor(new java.awt.Color(0, 0, 0, 0));

    ///////////////////////////// DRAWING ATTRIBUTES METHODS /////////////////////////////
    public void setFill(java.awt.Color fill) {
        this.fill = slickColorFromAWTColor(fill);
    }

    public void setStroke(java.awt.Color stroke) {
        this.stroke = slickColorFromAWTColor(stroke);
    }

    public void setLineWidth(float lineWidth) {
        graphics.setLineWidth(lineWidth);
    }

    public void setFont(Font font) {
        graphics.setFont(FontUtils.awtFontToSlickFont(font));
    }

    ///////////////////////////// DRAWING METHODS /////////////////////////////
    public void drawRect(float x, float y, float width, float height) {
        graphics.setColor(stroke);
        graphics.drawRect(x, y, width, height);
        graphics.setColor(fill);
        graphics.fillRect(x, y, width, height);
    }

    public void drawEllipse(float x, float y, float width, float height) {
        graphics.setColor(stroke);
        graphics.fillOval(x, y, width, height);
        graphics.setColor(fill);
        graphics.fillOval(x, y, width, height);
    }

    public void drawText(String text, float x, float y) {
        graphics.setColor(fill);
        graphics.drawString(text, x, y);
    }

    public void drawLine(float x1, float y1, float x2, float y2) {
        graphics.setColor(stroke);
        graphics.drawLine(x1, y1, x2, y2);
    }


    private static org.newdawn.slick.Color slickColorFromAWTColor(java.awt.Color awtColor) {
        int r = awtColor.getRed(),
            g = awtColor.getGreen(),
            b = awtColor.getBlue(),
            a = awtColor.getAlpha();
        return new org.newdawn.slick.Color(r, g, b, a);
    }
}
