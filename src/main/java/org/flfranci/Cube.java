package org.flfranci;

public class Cube implements Shape3d{
    private double width;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Cube(double width){
        this.width = width;
    }

    @Override
    public double getVolume() {
        return Math.pow(this.width,3);
    }
}
