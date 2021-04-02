package pong.game.graphics.adapters;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class GraphicLibraryAdapterFactory {
    public static String currentAdapterClassName;

    /** Cached active adapter. If you try to get adapter instances
     * using the same {@link #currentAdapterClassName}, you'll get
     * cached adapter after first request. */
    private static GraphicLibraryAdapterFactory.ActiveAdapter activeAdapter = new NullAdapter();

    @SuppressWarnings("unchecked")
    public static GraphicLibraryAdapter getAdapterInstance() {
        try {
            Objects.requireNonNull(currentAdapterClassName, "GraphicLibraryAdapterFactory.activeAdapter isn\'t defined");

            if (activeAdapter.classNameNotEquals(currentAdapterClassName)) {
                Class<?> adapterClass = Class.forName(currentAdapterClassName);

                if (adapterClass.isAssignableFrom(GraphicLibraryAdapter.class)) {
                    String exceptionMessage = String.format("%s doesn\'t implement interface %s",
                            currentAdapterClassName, GraphicLibraryAdapter.class.getName());
                    throw new InvalidAdapterClassException(exceptionMessage);
                } else {
                    Constructor<?>[] constructors = adapterClass.getDeclaredConstructors();

                    for (Constructor constructor : constructors) {
                        if (constructor.getParameterCount() == 0) {
                            GraphicLibraryAdapter adapterInstance = (GraphicLibraryAdapter) constructor.newInstance();
                            activeAdapter = new ActiveAdapter(currentAdapterClassName, adapterInstance);
                            return adapterInstance;
                        }
                    }

                    String exceptionMessage = String.format("%s doesn\'t contain constructor with parameter count 0",
                            currentAdapterClassName);
                    throw new InvalidAdapterClassException(exceptionMessage);
                }
            } else {
                return activeAdapter.instance;
            }
        } catch (ClassNotFoundException e) {
            // Can be caught if class with name ${currentAdapterClassName} can't be found
            throw new AdapterClassNotFoundException(currentAdapterClassName);
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
            // Can be caught while getting instance of adapter
            throw new GraphicLibraryException(e);
        }
    }

    private static class ActiveAdapter {
        public String className;
        public GraphicLibraryAdapter instance;

        public ActiveAdapter(String className, GraphicLibraryAdapter instance) {
            this.className = className;
            this.instance = instance;
        }
        
        public boolean classNameNotEquals(String other) {
            return !className.equals(other);
        }
    }
    
    private static class NullAdapter extends ActiveAdapter {
        public NullAdapter() {
            super(null, null);
        }
    
        @Override
        public boolean classNameNotEquals(String other) {
            return true;
        }
    }
}
