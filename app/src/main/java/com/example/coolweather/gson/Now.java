package com.example.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 实况天气
 */
public class Now {

    @SerializedName("tep")
    public String temperature;
    //实况天气状况代码
    public String cond_code;
    //实况天气状况描述
    public String cond_txt;

    //降水量
    public String precipitation;

    public String getTemperature() {
        return temperature;
    }

    public String getCond_code() {
        return cond_code;
    }

    public String getCond_txt() {
        return cond_txt;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setCond_code(String cond_code) {
        this.cond_code = cond_code;
    }

    public void setCond_txt(String cond_txt) {
        this.cond_txt = cond_txt;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }
}
