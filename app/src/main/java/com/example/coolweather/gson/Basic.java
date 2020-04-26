package com.example.coolweather.gson;

import com.example.coolweather.util.Utility;
import com.google.gson.annotations.SerializedName;

public class Basic {

    public String location;

    @SerializedName("cid")
    public String cityId;

    public String getLocation() {
        return location;
    }

    public String cityId() {
        return cityId;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCid(String cid) {
        this.cityId = cid;
    }

    public Update update;

    public class Update {
        //当地时间
        @SerializedName("loc")
        public String localTime;

        //UTC时间
        public String utc;

        public String localTime() {
            return localTime;
        }

        public String getUtc() {
            return utc;
        }

        public void setLoc(String loc) {
            this.localTime = loc;
        }

        public void setUtc(String utc) {
            this.utc = utc;
        }
    }
}
