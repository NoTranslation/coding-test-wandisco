package org.flfranci;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import static org.flfranci.Util.getRoundedValue;

public class SphereTest {

    @Test
    public void getVolumeShouldBeCorrect(){
        Sphere sphere1 = new Sphere(1);
        assertEquals(4.19, getRoundedValue(sphere1.getVolume(),2), 0.001);

        Sphere sphere2 = new Sphere(5);
        assertEquals(523.60,getRoundedValue(sphere2.getVolume(),2), 0.001);
    }
}
