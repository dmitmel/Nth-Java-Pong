package pong.game.graphics.adapters;

public class InvalidAdapterClassException extends GraphicLibraryException {
    public InvalidAdapterClassException() {
        super();
    }

    public InvalidAdapterClassException(String message) {
        super(message);
    }

    public InvalidAdapterClassException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidAdapterClassException(Throwable cause) {
        super(cause);
    }
}
