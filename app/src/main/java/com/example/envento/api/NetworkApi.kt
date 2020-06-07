package com.example.envento.api

import com.example.envento.adapter.EventListAdapter
import com.example.envento.model.Event
import io.reactivex.Observable
import io.reactivex.Observer
import retrofit2.http.GET
import java.util.*

interface NetworkApi {
    @GET("/api/createEvent/bhavit")
    fun getAllPosts(): Observable<List<Event>>
}