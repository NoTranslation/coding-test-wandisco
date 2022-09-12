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
        return new BigDecimal(value)
                .setScale(2, RoundingMode.HALF_EVEN)
                .doubleValue();
    }
}
