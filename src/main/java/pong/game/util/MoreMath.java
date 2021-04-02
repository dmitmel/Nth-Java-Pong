package pong.game.util;

import java.util.Random;

public class MoreMath {
    public static float map(float n, float inMin, float inMax, float outMin, float outMax) {
        return (n - inMin) * (outMax - outMin) / (inMax - inMin) + outMin;
    }


    private static final Random RANDOM_VALUES_GENERATOR = new Random();

    public static float randomInRange(float min, float max) {
        return map(RANDOM_VALUES_GENERATOR.nextFloat(), 0, 1, min, max);
    }

    public static boolean randomBoolean() {
        return RANDOM_VALUES_GENERATOR.nextBoolean();
    }
}
