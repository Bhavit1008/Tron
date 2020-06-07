package com.example.envento.model

import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("_id") val _id :String,
    @SerializedName("userId") val userId : String,
    @SerializedName("eventName") val eventName:String,
    @SerializedName("date") val date:String,
    @SerializedName("venue") val venue:String,
    @SerializedName("eventType") val eventType:String,
    @SerializedName("payment") val payment:String,
    @SerializedName("createdAt") val createdAt :String,
    @SerializedName("updatedAt") val updatedAt:String
)