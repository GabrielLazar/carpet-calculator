package com.gabriellazar.utils;

import com.gabriellazar.exception.DataNotFoundException;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CommonUtils {

    public static boolean isMoreThanZero(int number){
        if(number < 1){
            return false;
        }
        return true;
    }

    public static String formatDouble(Double number){
        return String.format("%.2f",number);
    }
}
