package com.example.training_final_project

import retrofit2.Call
import retrofit2.http.GET

interface film_service {
    @GET("/movie/popular?api_key=bbf5a3000e95f1dddf266b5e187d4b21")
    fun get_films():Call<List<Film>>

}