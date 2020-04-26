package com.example.coolweather.bean;

import com.example.coolweather.gson.Basic;
import com.example.coolweather.gson.Forecast;
import com.example.coolweather.gson.Now;
import com.example.coolweather.gson.LifeStyle;

import java.util.List;

public class Weather {

    public String status;
    public Basic basic;
    public Now now;
    public LifeStyle lifeStyle;

    public List<Forecast> forecastList;


}
