package com.gabriellazar.utils;

public class CommonUtils {

    /**
     * Check if the number is more than 0
     * @param number number to check
     * @return true or false;
     */

    public static boolean isMoreThanZero(int number){
        if(number < 1){
            return false;
        }
        return true;
    }

    /**
     * Format the double to 2 decimal points
     * @param number double to format
     * @return eg: "#.##"
     */
    public static String formatDouble(Double number){
        return String.format("%.2f",number);
    }
}
