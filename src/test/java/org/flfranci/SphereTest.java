package org.flfranci;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.flfranci.Util.getRoundedValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SphereTest {

    @Test
    @DisplayName("Sphere Volume is correct to 2 decimals")
    public void getVolumeShouldBeCorrect(){
        Sphere sphere1 = new Sphere(1);
        assertEquals(4.19, getRoundedValue(sphere1.getVolume(),2), 0.001);

        Sphere sphere2 = new Sphere(5);
        assertEquals(523.60,getRoundedValue(sphere2.getVolume(),2), 0.001);
    }
}
