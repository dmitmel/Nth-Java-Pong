package pong.game.graphics.adapters;

public class AdapterClassNotFoundException extends GraphicLibraryException {
    public AdapterClassNotFoundException() {
        super();
    }

    public AdapterClassNotFoundException(String message) {
        super(message);
    }

    public AdapterClassNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AdapterClassNotFoundException(Throwable cause) {
        super(cause);
    }
}
