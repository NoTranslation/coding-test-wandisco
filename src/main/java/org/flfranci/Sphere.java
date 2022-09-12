package org.flfranci;

public class Sphere implements Shape3d {

    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return ((double) 4 / 3) * Math.PI * Math.pow(this.radius, 3);
    }
}
