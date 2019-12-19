package com.example.kotlindemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlindemo.R
import com.example.kotlindemo.helpers.Post

 class PostAdapter (private val postList: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        var post = postList.get(position)
        holder.idTextView.text = post.id
        holder.titleTextView.text = post.title
    }


    class PostViewHolder(view : View): RecyclerView.ViewHolder(view){
        val idTextView: TextView = view.findViewById(R.id.id)
        val titleTextView: TextView = view.findViewById(R.id.title)
    }
}