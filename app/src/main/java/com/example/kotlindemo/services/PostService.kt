package com.example.kotlindemo.services

import com.example.kotlindemo.helpers.Post
import retrofit2.Call
import retrofit2.http.GET

interface PostService {

    @GET("posts")
    fun getPostList(): Call<List<Post>>

}