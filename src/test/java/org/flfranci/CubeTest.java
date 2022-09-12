package org.flfranci;





import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.flfranci.Util.getRoundedValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CubeTest {

    @Test
    @DisplayName("Cube Volume is correct to 2 decimals")
    public void getVolumeShouldBeCorrectTo2Decimals(){
        Cube cube1 = new Cube(1);

        assertEquals(1,getRoundedValue(cube1.getVolume(), 2), 0.001);

        Cube cube2 = new Cube(5);
        assertEquals(125,getRoundedValue(cube2.getVolume(),2), 0.001);
    }
}
