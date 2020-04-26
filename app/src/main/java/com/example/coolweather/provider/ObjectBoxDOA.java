package com.example.coolweather.provider;

import android.content.Context;

import com.example.coolweather.InitObjectBox;
import com.example.coolweather.bean.City;
import com.example.coolweather.bean.City_;
import com.example.coolweather.bean.County;
import com.example.coolweather.bean.County_;
import com.example.coolweather.bean.Province;

import java.util.List;
import java.util.Queue;

import io.objectbox.Box;
import io.objectbox.query.QueryBuilder;

public class ObjectBoxDOA {


    public long addCity (City city) {
        return City.getCityBox().put(city);
    }

    public long addProvince(Province province) {
        return Province.getProvinceBox().put(province);
    }

    public long addCounty(County county) {
        return County.getCountyBox().put(county);
    }


    public List<City> getCitiesByProvinceId(long provinceId) {
        QueryBuilder<City> builder = City.getCityBox().query();
        builder.equal(City_.provinceId,provinceId);
        return builder.build().find();
    }

    public List<Province> getAllProvinces() {
        QueryBuilder<Province> builder = Province.getProvinceBox().query();
        return builder.build().find();
    }

    public List<County> getCountiesByCityId(long cityId) {
        QueryBuilder<County> builder = County.getCountyBox().query();
        builder.equal(County_.cityId,cityId);
        return builder.build().find();
    }




}
