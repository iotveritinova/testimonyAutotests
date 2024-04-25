package ru.neoflex.model;

import com.google.gson.annotations.SerializedName;

public class SendFormDataItem {

    @SerializedName("date")
    private String date;

    @SerializedName("resultValue")
    private String resultValue;

    @SerializedName("coldWater")
    private String coldWater;

    @SerializedName("electric")
    private String electric;

    @SerializedName("gas")
    private String gas;

    @SerializedName("hotWater")
    private String hotWater;

    public String getDate() {
        return date;
    }

    public String getResultValue() {
        return resultValue;
    }

    public String getColdWater() {
        return coldWater;
    }

    public String getElectric() {
        return electric;
    }

    public String getGas() {
        return gas;
    }

    public String getHotWater() {
        return hotWater;
    }


}