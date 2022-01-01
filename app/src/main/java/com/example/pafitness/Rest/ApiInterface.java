package com.example.pafitness.Rest;

import com.example.pafitness.Model.GetFitnes;
import com.example.pafitness.Model.PostBooking;
import com.example.pafitness.Model.PostResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("data")
    Call<List<GetFitnes>> getFitnes(
    );



    @FormUrlEncoded
    @POST("book")
    Call<PostResponseModel> PostBooking(@Field("nama") String nama, @Field("nomor") String nomor);
//    @FormUrlEncoded
//    @PUT("kontak")
//    Call<PostPutDelKontak> putKontak(@Field("id") String id,
//                                     @Field("nama") String nama,
//                                     @Field("nomor") String nomor);
//    @FormUrlEncoded
//    @HTTP(method = "DELETE", path = "kontak", hasBody = true)
//    Call<PostPutDelKontak> deleteKontak(@Field("id") String id);


}


