package org.flfranci;


import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldRun()
    {
        String[] emptyArgs = new String[0];
        App.main(emptyArgs);
        assertTrue( true );
    }

}
