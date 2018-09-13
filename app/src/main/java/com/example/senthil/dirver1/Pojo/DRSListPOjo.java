package com.example.senthil.dirver1.Pojo;

import java.util.ArrayList;

public class DRSListPOjo {
    private boolean status;
    private String message;
    ArrayList<DRSListData> delievery_data = new ArrayList<DRSListData>();
    private boolean authentication;
    private float request_id;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<DRSListData> getDelievery_data() {
        return delievery_data;
    }

    public void setDelievery_data(ArrayList<DRSListData> delievery_data) {
        this.delievery_data = delievery_data;
    }

    public boolean isAuthentication() {
        return authentication;
    }

    public void setAuthentication(boolean authentication) {
        this.authentication = authentication;
    }

    public float getRequest_id() {
        return request_id;
    }

    public void setRequest_id(float request_id) {
        this.request_id = request_id;
    }
}
