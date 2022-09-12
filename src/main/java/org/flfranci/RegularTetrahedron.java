package org.flfranci;

public class RegularTetrahedron implements Shape3d {

    private double edgeLength;

    public double getEdgeLength() {
        return edgeLength;
    }

    public void setEdgeLength(double edgeLength) {
        this.edgeLength = edgeLength;
    }

    public RegularTetrahedron(double edgeLength) {
        this.edgeLength = edgeLength;
    }


    @Override
    public double getVolume() {
        return (Math.sqrt(2)/12) * Math.pow(this.edgeLength,3);
    }
}
