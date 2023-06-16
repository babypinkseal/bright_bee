package com.example.brightbee.network

import com.example.brightbee.data.LearningMaterial
import com.example.brightbee.data.SignInRequest
import com.example.brightbee.data.SignInResponse
import com.example.brightbee.data.SignUpRequest
import com.example.brightbee.data.SignUpResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    // Define your API endpoints here
    @POST("users/signin")
    suspend fun signInUser(@Body signInRequest: SignInRequest): SignInResponse
    @POST("users/signup")
    suspend fun signUpUser(@Body signUpRequest: SignUpRequest): SignUpResponse
    @GET("materials")
    suspend fun getLearningMaterials(
        @Query("keyword") keyword: String?,
        @Query("category") category: String?,
        @Query("rating") rating: Int?
    ): List<LearningMaterial>
}
