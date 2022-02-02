package com.example.gliderimages.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideContext
import com.example.gliderimages.R
import com.example.gliderimages.databinding.PhotoItemsBinding
import com.example.gliderimages.network.models.PhotoModel
import kotlin.coroutines.coroutineContext

class PhotoAdapter(
    private val userList: List<PhotoModel>
) : RecyclerView.Adapter<PhotoAdapter.UserViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PhotoItemsBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])





    }

    override fun getItemCount(): Int {
        return userList.size
    }


    class UserViewHolder(private val binding: PhotoItemsBinding ) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(photo: PhotoModel ) {
            with(binding) {
                albumTv.text = photo.albumId.toString()
                titleTv.text = photo.title
                urlTv.text = photo.url

                val urls = photo.thumbnailUrl

                Glide.with(photoImage.context)
                    .load("${urls}.png")
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(photoImage)


            }
        }
    }
}