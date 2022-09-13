package org.flfranci;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Util {
    public static int tryParseInt(String value, int defaultVal) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultVal;
        }
    }

    public static double getRoundedValue(double value, int decimals){
        //Scales the double value to requested decimal places
        return new BigDecimal(value)
                .setScale(decimals, RoundingMode.HALF_EVEN)
                .doubleValue();
    }
}
