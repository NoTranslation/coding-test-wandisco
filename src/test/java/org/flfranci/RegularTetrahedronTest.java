package org.flfranci;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.flfranci.Util.getRoundedValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegularTetrahedronTest {

    @Test
    @DisplayName("RegularTetrahedron Volume is correct to 2 decimals")
    public void getVolumeShouldBeCorrect(){
        RegularTetrahedron tetrahedron1 = new RegularTetrahedron(1);
        assertEquals(0.12,getRoundedValue(tetrahedron1.getVolume(),2), 0.001);

        RegularTetrahedron tetrahedron2 = new RegularTetrahedron(5);
        assertEquals(14.73,getRoundedValue(tetrahedron2.getVolume(),2), 0.001);

    }
}
