package com.example.myrvexample.data

import android.content.Context
import com.example.myrvexample.R
import com.example.myrvexample.model.Place

class DataSource(val context: Context) {
    fun getUserNamesList(): Array<String>{
        return context.resources.getStringArray(R.array.place_name_array)
    }
    fun getUserLocationList(): Array<String>{
        return context.resources.getStringArray(R.array.location_array)
    }
    fun getUserProfileDescList(): Array<String>{
        return context.resources.getStringArray(R.array.description_array)
    }
    fun getUserBestTimeList(): Array<String>{
        return context.resources.getStringArray(R.array.best_time_array)
    }
    fun getUserImagesList(): Array<Int> {
        return arrayOf(
            R.drawable.grand_canyon,
            R.drawable.eiffel_tower,
            R.drawable.great_wall,
            R.drawable.machu_picchu,
            R.drawable.santorini,
            R.drawable.banff_national_park,
            R.drawable.pyramids_of_giza,
            R.drawable.fuji_mount,
            R.drawable.liberty,
            R.drawable.sydney_opera_house
        )
    }

    fun loadUsers(): List<Place>{
        val namesList = getUserNamesList()
        val locationList = getUserLocationList()
        val profileDescriptionList  = getUserProfileDescList()
        val bestTimeList = getUserBestTimeList()
        val imagesList = getUserImagesList()

        val users = mutableListOf<Place>()
        for (i in namesList.indices){
            users.add(Place(name = namesList[i], location = locationList[i], description = profileDescriptionList[i], bestTimeToVisit = bestTimeList[i], imageResId = imagesList[i] ))
        }
        return users
    }
}