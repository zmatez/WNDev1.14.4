package com.matez.wildnature.world.gen.biomes.biomes.surface.cracked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Crack {
    public static int WIDTH = 500;
    public static int HEIGHT = 500;
    public static int RECURSION_LEVELS = 3;
    public static int AMOUNT_OF_POINTS = 5;
    public static int ROTATION_RESOLUTION = 600;
    public static int ROTATION_SMOOTHNESS = 10;
    public static int BACKGROUND = 0xFFE0CBAD;

    public static Random RAND;

    public Crack(){
        ArrayList<Vector> points = new ArrayList<Vector>();
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                points.add(new Vector(x, y));
            }
        }
        generateSoil(points, AMOUNT_OF_POINTS, RECURSION_LEVELS);
    }

    private static void generateSoil(ArrayList<Vector> drawPoints,
            int amountOfPoints, int recursionLevel) {

        ArrayList<VoronoiPoint> points = new ArrayList<VoronoiPoint>();
        for (int i = 0; i < amountOfPoints; i++) {
            points.add(new VoronoiPoint(drawPoints.get(RAND.nextInt(drawPoints.size()))));
        }

        HashMap<Integer, ArrayList<Vector>> pointMaps = new HashMap<Integer, ArrayList<Vector>>();
        for (VoronoiPoint point : points) {
            pointMaps.put(point.hashCode(), new ArrayList<Vector>());
        }
        System.out.println(pointMaps);

        System.out.println(points);

        for (Vector v : drawPoints) {
            VoronoiPoint closest = null;
            VoronoiPoint secondClosest = null;

            for (VoronoiPoint point : points) {
                double distance = point.getMultiplicativeDistanceTo(v);
                if (closest == null || distance < closest.getMultiplicativeDistanceTo(v)) {
                    secondClosest = closest;
                    closest = point;
                } else if (secondClosest == null || distance < secondClosest.getMultiplicativeDistanceTo(v)) {
                    secondClosest = point;
                }
            }

            int col = 0;
            if (Math.abs(closest.getMultiplicativeDistanceTo(v)
                    - secondClosest.getMultiplicativeDistanceTo(v)) < (recursionLevel * 5 / RECURSION_LEVELS)) {
                col = 0x01000000 * (recursionLevel * 255 / RECURSION_LEVELS);
            } else {
                pointMaps.get(closest.hashCode()).add(v);
            }
            Block((int) v.getX(), (int) v.getY());
        }
    }

    public static int modInts(int a, int b) {
        return (int) mod(a, b);
    }

    public static double mod(double a, double b) {
        a = a % b;
        while (a < 0)
            a += b;
        return a;
    }

    public static void Block(int x, int z){

    }
}