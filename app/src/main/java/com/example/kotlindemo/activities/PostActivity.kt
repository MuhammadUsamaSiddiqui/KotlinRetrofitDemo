package com.example.kotlindemo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlindemo.R
import com.example.kotlindemo.adapter.PostAdapter
import com.example.kotlindemo.databinding.ActivityMainBinding
import com.example.kotlindemo.helpers.Post
import com.example.kotlindemo.helpers.ServiceBuilder
import com.example.kotlindemo.services.PostService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostActivity : AppCompatActivity(), Callback<List<Post>> {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =  DataBindingUtil.setContentView(this,R.layout.activity_main)
        init()
        networkCall()
    }
    private fun init() {
        binding.postRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
    }

    private fun networkCall() {

        val postService = ServiceBuilder.buildService(PostService::class.java)
        val requestCall = postService.getPostList()

        requestCall.enqueue(this)
    }

    override fun onFailure(call: Call<List<Post>>, t: Throwable) {
        Log.e("Error",t.message)
    }

    override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
        if (response.isSuccessful) {
            val postList = response.body()!!
            binding.postRecyclerView!!.adapter = PostAdapter(postList)
        }
    }

}
