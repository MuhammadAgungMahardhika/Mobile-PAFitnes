package com.example.pafitness.Rest;

import com.example.pafitness.Model.GetBookingClass;
import com.example.pafitness.Model.GetFitnes;
import com.example.pafitness.Model.PostBooking;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("data")
    Call<List<GetFitnes>> getFitnes(
    );

    @GET("getClass")
    Call<List<GetBookingClass>> getBookingClass(
            @Query("id_user") String id_user
    );


    @POST("/bookFitnes")
    @FormUrlEncoded
    Call<PostBooking> savePost(@Field("id_fitnes") long id_fitnes,
                               @Field("id_user") String id_user,
                               @Field("tanggal_booking") String tanggal_booking);

//    @FormUrlEncoded
//    @PUT("kontak")
//    Call<PostPutDelKontak> putKontak(@Field("id") String id,
//                                     @Field("nama") String nama,
//                                     @Field("nomor") String nomor);
//    @FormUrlEncoded
//    @HTTP(method = "DELETE", path = "kontak", hasBody = true)
//    Call<PostPutDelKontak> deleteKontak(@Field("id") String id);


}


