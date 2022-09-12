package org.flfranci;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import static org.flfranci.Util.getRoundedValue;

public class RegularTetrahedronTest {

    @Test
    public void getVolumeShouldBeCorrect(){
        RegularTetrahedron tetrahedron1 = new RegularTetrahedron(1);
        assertEquals(0.12,getRoundedValue(tetrahedron1.getVolume(),2), 0.001);

        RegularTetrahedron tetrahedron2 = new RegularTetrahedron(5);
        assertEquals(14.73,getRoundedValue(tetrahedron2.getVolume(),2), 0.001);

    }
}
