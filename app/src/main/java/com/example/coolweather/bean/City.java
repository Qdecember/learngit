package com.example.coolweather.bean;

import com.example.coolweather.InitObjectBox;

import io.objectbox.Box;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class City {
    @Id private long id;

    private String cityName;

    private int cityCode;

    private long provinceId;

    private static Box<City> cityBox;


    public static Box<City> getCityBox() {
        if (cityBox == null) {
            cityBox = InitObjectBox.getBoxStore().boxFor(City.class);
        }
        return cityBox;
    }

    public long getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(long provinceId) {
        this.provinceId = provinceId;
    }
}
