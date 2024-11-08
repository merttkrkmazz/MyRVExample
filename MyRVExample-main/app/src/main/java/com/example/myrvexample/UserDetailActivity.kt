package com.example.myrvexample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.myrvexample.databinding.ActivityUserDetailBinding
import android.widget.ImageView

class UserDetailActivity : AppCompatActivity() {
    companion object{
        const val PLACE_NAME = "place_name"
        const val PLACE_ADDR = "place_addr"
        const val PLACE_PROFILE = "place_profile"
        const val PLACE_IMAGE = "place_image"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_user_detail)
        val binding: ActivityUserDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail)

        val placeName = intent.getStringExtra(PLACE_NAME)
        val placeProfile = intent.getStringExtra(PLACE_PROFILE)
        val placeAddress = intent.getStringExtra(PLACE_ADDR)
        val placeImageResId = intent.getIntExtra(PLACE_IMAGE, 0)

        binding.nameView.text = placeName
        binding.addrView.text = placeAddress
        binding.profileView.text = placeProfile
        binding.placeImageView.setImageResource(placeImageResId)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}