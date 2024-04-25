package ru.neoflex.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SendFormDataList {

    @SerializedName("SendPageData")
    private List<SendFormData> sendPageData;

    public List<SendFormData> getSendPageData() {
        return sendPageData;
    }
}