package com.example.envento.api

import com.example.envento.model.EventResponse
import com.example.envento.model.LoginResponse
import com.example.envento.model.RegistrationResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RetrofitApi {
    @FormUrlEncoded
    @POST("/api/interested")
    fun createUser(
        @Field("eventId") eventId:String,
        @Field("fullName") fullName:String,
        @Field("email") email:String,
        @Field("registrationType") registrtationType:String,
        @Field("phoneNumber") phoneNumber:String,
        @Field("ticketCount") ticketCount:String
    ): retrofit2.Call<EventResponse>

    @FormUrlEncoded
    @POST("/api/user/login")
    fun loginUser(
        @Field("email") email:String,
        @Field("password") password:String
    ):retrofit2.Call<LoginResponse>


    @FormUrlEncoded
    @POST("/api/user/register")
    fun createUser(
        @Field("fullName") name:String,
        @Field("phoneNumber") number:String,
        @Field("email") email:String,
        @Field("password") password:String
    ): retrofit2.Call<RegistrationResponse>



}