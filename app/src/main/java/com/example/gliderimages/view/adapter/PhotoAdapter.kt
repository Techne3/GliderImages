package com.example.gliderimages.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gliderimages.databinding.PhotoItemsBinding
import com.example.gliderimages.network.models.PhotoModel

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



        class UserViewHolder(private val binding: PhotoItemsBinding) :
            RecyclerView.ViewHolder(binding.root) {



            fun bind(photo: PhotoModel) {
                var url = "https://picsum.photo/80"
                with(binding) {
                    albumTv.text = photo.albumId.toString()
                    titleTv.text = photo.title
                    urlTv.text = photo.url
                }
            }
        }
    }