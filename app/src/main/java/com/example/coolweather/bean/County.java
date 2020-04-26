package com.example.coolweather.bean;

import com.example.coolweather.InitObjectBox;

import io.objectbox.Box;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
@Entity
public class County {
    @Id private long id;

    private String countyName;

    private String weatherId;

    private long cityId;

    private static Box<County> countyBox;

    public static Box<County> getCountyBox() {
        if (countyBox == null) {
            countyBox = InitObjectBox.getBoxStore().boxFor(County.class);
        }
        return countyBox;
    }


    public long getId() {
        return id;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getCountyName() {
        return countyName;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }
}
