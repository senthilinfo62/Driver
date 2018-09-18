package com.example.senthil.dirver1.Retrofit;

import com.example.senthil.dirver1.Pojo.DRSListPOjo;
import com.example.senthil.dirver1.Pojo.ForgetPojo;
import com.example.senthil.dirver1.Pojo.PickupPojo;
import com.example.senthil.dirver1.Pojo.RegisterationPojo;
import com.example.senthil.dirver1.Pojo.RrgPojo;

import java.net.URLEncoder;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {
    @FormUrlEncoded
    @POST("register_courier")
    Call<RegisterationPojo> RegisterPost(@Field("name") String regName, @Field("country") String regCountry, @Field("state") String regState,
                                         @Field("code") String regCode, @Field("mobile") String regMobile, @Field("email") String regEmail,
                                         @Field("iqama_id")String regIqamaId, @Field("Upload Iqama/ID") String regUpladIqmaID,
                                         @Field("Upload license") String regLicence, @Field("vehicle_type")String regVehicleType,
                                         @Field("supplier") String regSupplier, @Field("join_date")String date,
                                         @Field("password")String regPassword, @Field("vehicle_number") String regVehicleNumber,
                                         @Field("profile_image") String profileName);
    @FormUrlEncoded
    @POST("login_courier")
    Call<RrgPojo> LoginPost(@Field("email") String userName, @Field("password") String password);
    @FormUrlEncoded
    @POST("forget_password_courier")
    Call<ForgetPojo> ForgotPost(@Field("email") String emailid, @Field("password") String finalpassword);
    @FormUrlEncoded
    @POST("get_delievery_list")
    Call<DRSListPOjo> DeliveryList(@Field("language") String lanuage, @Field("device_type") String divicetype);

    @POST("register_courier")
    Call<RegisterationPojo> RegisterPost1(@Body String json);
    @FormUrlEncoded
    @POST("get_pickup_list")
    Call<PickupPojo> PickupList(@Field("language") String lanuage, @Field("device_type") String divicetype);
    @FormUrlEncoded
    @POST("update_shipment_status")
    Call<ForgetPojo> updateDeliveryStatus(@Field("track_id") String trackId,@Field("shipment_status") String delDetails);
}
