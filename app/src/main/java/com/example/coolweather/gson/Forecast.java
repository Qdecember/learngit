package com.example.coolweather.gson;

import com.google.gson.annotations.SerializedName;

public class Forecast {

    public String date;

    @SerializedName("tmp")
    public Temperature temperature;

    @SerializedName("cond")
    public More more;

     public class Temperature {
         public String maxTem; //最高温度
         public String minTem;  //最低温度
     }


     public class More {
         public String dayCon;  //白天天气情况
         public String nightCon;  //夜晚天气情况
     }
}
