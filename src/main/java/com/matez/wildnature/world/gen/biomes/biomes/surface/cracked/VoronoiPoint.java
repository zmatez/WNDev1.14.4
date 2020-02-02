package com.matez.wildnature.world.gen.biomes.biomes.surface.cracked;

public class VoronoiPoint {

    private Vector pos;
    private double[] distances;

    public VoronoiPoint(Vector pos) {
        this.pos = pos;
        distances = new double[Crack.ROTATION_RESOLUTION];
        for (int i = 0; i < distances.length; i++)
            distances[i] = Crack.RAND.nextFloat() / 2 + 0.51;

        for (int iter = 0; iter < Crack.ROTATION_SMOOTHNESS; iter++) {
            for (int i = 0; i < distances.length; i++) {
                distances[i] = (distances[Crack.modInts(i - Crack.RAND.nextInt(4) - 2, distances.length)] + distances[i]
                        + distances[Crack.modInts(i + Crack.RAND.nextInt(4) - 2, distances.length)]) / 3;
            }
        }
    }

    public Vector getPos() {
        return pos;
    }

    public double getRotationFromAngle(double radians) {
        return distances[(int) (Crack.mod(Math.toDegrees(radians) / 360, 1) * distances.length)];
    }

    public double getRotationFromVector(Vector vec) {
        return getRotationFromAngle(Math.atan2(pos.getY() - vec.getY(), -(pos.getX() - vec.getX())));
    }

    public double getMultiplicativeDistanceTo(Vector other) {
        return pos.getLengthTo(other) * getRotationFromVector(other);
    }

    public String toString() {
        return "VoronoiPoint(pos=[" + pos.getX() + ", " + pos.getY() + "])";
    }

    public int hashCode() {
        return distances.hashCode() ^ pos.hashCode();
    }
}