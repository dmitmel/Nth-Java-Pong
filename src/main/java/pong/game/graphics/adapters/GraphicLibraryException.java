package pong.game.graphics.adapters;

public class GraphicLibraryException extends RuntimeException {
    public GraphicLibraryException() {
        super();
    }

    public GraphicLibraryException(String message) {
        super(message);
    }

    public GraphicLibraryException(String message, Throwable cause) {
        super(message, cause);
    }

    public GraphicLibraryException(Throwable cause) {
        super(cause);
    }
}
