package io.github.ai.astar;

public class PointUtil {
    public static float getDistance(Point first, Point end) {
        return (float) Math.sqrt(Math.pow(first.getX() - end.getX(), 2) + Math.pow(first.getY() - end.getY(), 2));

    }

}
