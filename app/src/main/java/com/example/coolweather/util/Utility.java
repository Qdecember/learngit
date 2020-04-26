package com.example.coolweather.util;

import android.text.TextUtils;
import android.util.Log;

import com.example.coolweather.bean.City;
import com.example.coolweather.bean.County;
import com.example.coolweather.bean.Province;
import com.example.coolweather.bean.Weather;
import com.example.coolweather.provider.ObjectBoxDOA;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Utility {
    private static String TAG = "Utility";

//    private Box<Province> provinceBox = ObjectBox.init();

    private static ObjectBoxDOA objectBoxDOA = new ObjectBoxDOA();


    /**解析和处理服务器返回的省级数据
     * @param response
     * @return
     */
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvinces = new JSONArray(response);
                Log.d(TAG, "handleProvinceResponse: "+ allProvinces.toString());
                for (int i = 0;i < allProvinces.length(); i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    objectBoxDOA.addProvince(province);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }


    /**解析和处理服务器返回的市级数据
     * @param response
     * @param provinceId
     * @return
     */
    public static boolean handleCityResponse(String response,long provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCities = new JSONArray(response);
                Log.d(TAG, "handleCityResponse: "+allCities.toString());
                for (int i = 0;i<allCities.length();i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    objectBoxDOA.addCity(city);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }



    public static boolean handleCountyResponse(String response,long cityId){

        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCounties = new JSONArray(response);
                Log.d(TAG, "handleCountyResponse: "+allCounties.toString());
                for (int i = 0;i <allCounties.length();i++) {
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    objectBoxDOA.addCounty(county);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    public static Weather handleWeatherResponse(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather6");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        }catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
