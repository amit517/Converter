package com.example.amitkundu.converter;

public class TemperatureCalculate {
    public static double ftoc(double f)
    {

        return ((f-32)/1.8);
    }

    public static double ctof(double c)
    {
        return (((9*c)/5)+32);
    }
}
