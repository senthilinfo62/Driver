package com.example.senthil.dirver1.Pojo;

import java.util.ArrayList;

public class PickupPojo {
  private boolean status;
  private String message;
  ArrayList<PickUpArrayList> pickup_data = new ArrayList<PickUpArrayList>();
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

  public ArrayList<PickUpArrayList> getPickup_data() {
    return pickup_data;
  }

  public void setPickup_data(ArrayList<PickUpArrayList> pickup_data) {
    this.pickup_data = pickup_data;
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