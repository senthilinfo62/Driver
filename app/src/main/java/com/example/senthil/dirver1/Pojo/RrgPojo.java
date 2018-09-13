package com.example.senthil.dirver1.Pojo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RrgPojo {
    private boolean status;
    private String message;
    @SerializedName("user_data")
    User_data User_dataObject;
    private boolean authentication;
    private float request_id;


    // Getter Methods

    public boolean getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public User_data getUser_dataObject() {
        return User_dataObject;
    }

    public void setUser_dataObject(User_data user_dataObject) {
        User_dataObject = user_dataObject;
    }

    public boolean getAuthentication() {
        return authentication;
    }

    public float getRequest_id() {
        return request_id;
    }

    // Setter Methods

    public void setStatus( boolean status ) {
        this.status = status;
    }

    public void setMessage( String message ) {
        this.message = message;
    }



    public void setAuthentication( boolean authentication ) {
        this.authentication = authentication;
    }

    public void setRequest_id( float request_id ) {
        this.request_id = request_id;
    }

}
