package com.example.coolweather.bean;

import com.example.coolweather.InitObjectBox;

import io.objectbox.Box;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Province {
    @Id private long id;

    private String provinceName;

    private int provinceCode;

    private static Box<Province> provinceBox;

    public static Box<Province> getProvinceBox () {
        if (provinceBox == null) {
            provinceBox = InitObjectBox.getBoxStore().boxFor(Province.class);
        }
        return provinceBox;
    }

    public long getId() {
        return id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }


}
