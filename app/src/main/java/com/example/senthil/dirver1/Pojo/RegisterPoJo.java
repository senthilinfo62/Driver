package com.example.senthil.dirver1.Pojo;

import com.google.gson.annotations.SerializedName;

public class RegisterPoJo {
    @SerializedName("first_name")
    String firstName;
    @SerializedName("last_name")
    String lastName;
    @SerializedName("gender")
    String gender;
    @SerializedName("dob")
    String dob;
    @SerializedName("email")
    String emailId;
    @SerializedName("country_code")
    String countryCode;
    @SerializedName("phone_no")
    String phoneNo;
    @SerializedName("language")
    String lanuage;
    @SerializedName("device_type")
    String diviceType;
    @SerializedName("user_name")
    String Username;
    @SerializedName("password")
    String password;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getLanuage() {
        return lanuage;
    }

    public void setLanuage(String lanuage) {
        this.lanuage = lanuage;
    }

    public String getDiviceType() {
        return diviceType;
    }

    public void setDiviceType(String diviceType) {
        this.diviceType = diviceType;
    }
}
