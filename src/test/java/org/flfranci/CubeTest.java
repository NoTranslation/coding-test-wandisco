package org.flfranci;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.flfranci.Util.getRoundedValue;

public class CubeTest {

    @Test
    public void getVolumeShouldBeCorrectTo2Decimals(){
        Cube cube1 = new Cube(1);

        assertEquals(1,getRoundedValue(cube1.getVolume(), 2), 0.001);

        Cube cube2 = new Cube(5);
        assertEquals(125,getRoundedValue(cube2.getVolume(),2), 0.001);
    }
}
