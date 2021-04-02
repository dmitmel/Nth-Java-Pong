package pong.game.graphics.common;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import pong.game.graphics.adapters.GraphicLibraryException;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class FontUtils {
    public static HashMap<java.awt.Font, org.newdawn.slick.Font> fontConversionCache = new HashMap<>(0);
    /**
     * Converts {@link java.awt.Font AWT fonts} to
     * {@link org.newdawn.slick.Font Slick fonts}. Caches converted
     * fonts in the {@link #fontConversionCache}. Conversion takes
     * some time, because method needs to load font data.
     */
    public static org.newdawn.slick.Font awtFontToSlickFont(java.awt.Font awtFont) {
        try {
            if (fontConversionCache.containsKey(awtFont)) {
                return fontConversionCache.get(awtFont);

            } else {
                UnicodeFont slickFont = new UnicodeFont(awtFont);
                slickFont.addAsciiGlyphs();
                // noinspection unchecked
                slickFont.getEffects().add(new ColorEffect());
                slickFont.loadGlyphs();

                fontConversionCache.put(awtFont, slickFont);
                return slickFont;
            }
        } catch (SlickException e) {
            throw new GraphicLibraryException(e);
        }
    }

    public static FontMetrics getFontMetrics(Font font) {
        Canvas canvas = new Canvas();
        return canvas.getFontMetrics(font);
    }

    public static int getLineHeight(Font font) {
        FontMetrics fontMetrics = getFontMetrics(font);
        return fontMetrics.getHeight();
    }

    public static int getStringWidth(Font font, String text) {
        FontMetrics fontMetrics = getFontMetrics(font);
        return fontMetrics.stringWidth(text);
    }

    public static Font fromTrueTypeInputStream(InputStream inputStream) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, inputStream);
        } catch (IOException | FontFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
