package com.example.senthil.dirver1.Pojo;

import com.google.gson.annotations.SerializedName;

public class RegisterPoJo {
    @SerializedName("name")
    String regName;
    @SerializedName("country")
    String regCountry;
    @SerializedName("state")
    String regState;
    @SerializedName("code")
    String regCode;
    @SerializedName("mobile")
    String regMobile;
    @SerializedName("email")
    String regEmail;
    @SerializedName("iqama_id")
    String regIqamaId;
    @SerializedName("Upload Iqama/ID")
    String regUpladIqmaID;
    @SerializedName("Upload license")
    String regLicence;
    @SerializedName("vehicle_type")
    String regVehicleType;
    @SerializedName("supplier")
    String regSupplier;
    @SerializedName("join_date")
    String date;
    @SerializedName("password")
    String regPassword;
    @SerializedName("vehicle_number")
    String RegVehicleNumber;
    @SerializedName("profile_image")
    String profilepath;


    public String getRegName() {
        return regName;
    }

    public void setRegName(String regName) {
        this.regName = regName;
    }

    public String getRegCountry() {
        return regCountry;
    }

    public void setRegCountry(String regCountry) {
        this.regCountry = regCountry;
    }

    public String getRegState() {
        return regState;
    }

    public void setRegState(String regState) {
        this.regState = regState;
    }

    public String getRegCode() {
        return regCode;
    }

    public void setRegCode(String regCode) {
        this.regCode = regCode;
    }

    public String getRegMobile() {
        return regMobile;
    }

    public void setRegMobile(String regMobile) {
        this.regMobile = regMobile;
    }

    public String getRegEmail() {
        return regEmail;
    }

    public void setRegEmail(String regEmail) {
        this.regEmail = regEmail;
    }

    public String getRegIqamaId() {
        return regIqamaId;
    }

    public void setRegIqamaId(String regIqamaId) {
        this.regIqamaId = regIqamaId;
    }

    public String getRegUpladIqmaID() {
        return regUpladIqmaID;
    }

    public void setRegUpladIqmaID(String regUpladIqmaID) {
        this.regUpladIqmaID = regUpladIqmaID;
    }

    public String getRegLicence() {
        return regLicence;
    }

    public void setRegLicence(String regLicence) {
        this.regLicence = regLicence;
    }

    public String getRegVehicleType() {
        return regVehicleType;
    }

    public void setRegVehicleType(String regVehicleType) {
        this.regVehicleType = regVehicleType;
    }

    public String getRegSupplier() {
        return regSupplier;
    }

    public void setRegSupplier(String regSupplier) {
        this.regSupplier = regSupplier;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRegPassword() {
        return regPassword;
    }

    public void setRegPassword(String regPassword) {
        this.regPassword = regPassword;
    }

    public String getRegVehicleNumber() {
        return RegVehicleNumber;
    }

    public void setRegVehicleNumber(String regVehicleNumber) {
        RegVehicleNumber = regVehicleNumber;
    }

    public String getProfilepath() {
        return profilepath;
    }

    public void setProfilepath(String profilepath) {
        this.profilepath = profilepath;
    }
}



