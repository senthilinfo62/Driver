package com.example.senthil.dirver1.Pojo;

public class ForgetPojo {
    private boolean status;
    private String message;
    private boolean authentication;
    private float request_id;


    // Getter Methods

    public boolean getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
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
