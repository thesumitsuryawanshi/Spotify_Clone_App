package com.plcoding.spotifycloneyt.View.adapters

import androidx.recyclerview.widget.AsyncListDiffer
import com.plcoding.spotifycloneyt.R
import com.plcoding.spotifycloneyt.databinding.SwipeItemBinding

//class OLDSwipeSongAdapter : BaseSongAdapter(R.layout.swipe_item) {
//
//
//
//    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
//        val song = songs[position]
//        holder.itemView.apply {
//            val text = "${song.title} - ${song.subTitle}"
//            tvPrimary.text = text
//
//            setOnClickListener {
//                onItemClickListener?.let { click ->
//                    click(song)
//                }
//            }
//        }
//    }
//
//
//
//}
//
//
//--------------------------------------------------------------------------------------------------------------------------------
//


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.plcoding.spotifycloneyt.Model.data.entities.Song
import javax.inject.Inject



class SwipeSongAdapter @Inject constructor(
    val glide: RequestManager, val songs: List<Song>, private val listener: SwipeSongsCLicked?
) : RecyclerView.Adapter<SwipeSongAdapter.SwipeSongViewHolder>() {

    lateinit var binding: SwipeItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwipeSongViewHolder {

        val view = SwipeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewholder = SwipeSongViewHolder(view)
        return viewholder
    }


    override fun onBindViewHolder(holder: SwipeSongViewHolder, position: Int) {
        val song = songs[position]
        holder.itemView.apply {
            val text = "${song.title} - ${song.subTitle}"
            holder.name.text = text

            holder.itemView.rootView.setOnClickListener {

                listener?.SwipeSongCLicked(song)
            }
        }
    }

    override fun getItemCount(): Int {
        return songs.size
    }


    class SwipeSongViewHolder(binding: SwipeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var name = binding.tvPrimary

    }


    interface SwipeSongsCLicked {

        fun SwipeSongCLicked(song: Song) {

        }
    }

}

















