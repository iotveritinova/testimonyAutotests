package ru.neoflex.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SendFormData {

    @SerializedName("SendPageData")
    private List<SendFormDataItem> sendPageData;

    public List<SendFormDataItem> getSendPageData() {
        return sendPageData;
    }
}