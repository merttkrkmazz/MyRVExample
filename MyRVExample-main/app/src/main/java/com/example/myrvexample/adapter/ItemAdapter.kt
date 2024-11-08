package com.example.myrvexample.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myrvexample.R
import com.example.myrvexample.UserDetailActivity
import com.example.myrvexample.model.Place


class ItemAdapter(private val data: List<Place>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        private lateinit var place: Place
        val nameTextView: TextView = view.findViewById(R.id.placeNameTextView)
        val locationTextView: TextView = view.findViewById(R.id.locationTextView)
        val bestTimeTextView: TextView = view.findViewById(R.id.bestTimeTextView)
        val placeImageView: ImageView = view.findViewById(R.id.placeImageView)

        init {
            view.setOnClickListener{
                val context = itemView.context
                val showUserIntent = Intent(context, UserDetailActivity::class.java)
                showUserIntent.putExtra(UserDetailActivity.PLACE_NAME, place.name)
                showUserIntent.putExtra(UserDetailActivity.PLACE_ADDR, place.location)
                showUserIntent.putExtra(UserDetailActivity.PLACE_PROFILE, place.description)
                showUserIntent.putExtra(UserDetailActivity.PLACE_IMAGE, place.imageResId)
                context.startActivity(showUserIntent)
            }
        }
        @SuppressLint("ResourceType")
        fun bind(place:Place){
            this.place = place
            nameTextView.text = place.name
            locationTextView.text = place.location
            bestTimeTextView.text = place.bestTimeToVisit
            placeImageView.setImageResource(place.imageResId)  // Görüntüyü ayarla
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val place = data[position]
        holder.bind(place)
//        holder.nameView.text = user.name
//        holder.profileView.text = user.profileDesc

    }
}