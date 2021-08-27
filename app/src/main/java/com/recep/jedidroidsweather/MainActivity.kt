package com.recep.jedidroidsweather

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    val cityList = mutableListOf("London", "Istanbul", "Berlin", "Athens")

    //    val weatherConditionList = mutableListOf("Foggy", "Snowy", "Clear", "Rainy")
    var cityOrder: Int = 0

    val city: TextView by lazy { findViewById(R.id.citylabel_MainActivity_textView) }
    val dateInformation: TextView by lazy { findViewById(R.id.date_MainActivity_textView) }
    val temparature: TextView by lazy { findViewById(R.id.temparature_MainActivity_textView) }
    val weatherDescription: TextView by lazy { findViewById(R.id.weather_description_info_MainActivity_textView) }
    val background: View by lazy { findViewById(R.id.constraint_MainActivity) }

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        randomCity()

        val calendar = Calendar.getInstance()
        val date = SimpleDateFormat("EEEE, dd MMM yyyy").format(calendar.time)

        dateInformation.text = date
        Log.e("onCreate", date)
    }


    override fun onUserInteraction() {
        super.onUserInteraction()

        getCity(cityList[cityOrder])
    }

    private fun getCity(cityName: String) {
        // This function returns city names with some weather info in specific order
        city.text = cityName
        when (cityName) {
            "London" -> {
                temparature.text = "8°"
                weatherDescription.text = "Rainy"
                background.setBackgroundResource(R.drawable.background_rain)
            }
            "Istanbul" -> {
                temparature.text = "22°"
                weatherDescription.text = "Clear"
                background.setBackgroundResource(R.drawable.background_clear_night)
            }
            "Berlin" -> {
                temparature.text = "-2°"
                weatherDescription.text = "Snowy"
                background.setBackgroundResource(R.drawable.background_snow)
            }
            else -> {
                temparature.text = "6°"
                weatherDescription.text = "Foggy"
                background.setBackgroundResource(R.drawable.background_fog)
            }
        }

        if (cityOrder == 3) {
            cityOrder = 0
        } else cityOrder++

    }

    private fun randomCity() {
        // This function use for shuffle to cityList and returns random city via randomWeatherConditions()
        // Not using for week-1 UI challenge
        cityList.shuffle()
        val currentCity = cityList[(0..3).random()]
        city.text = currentCity

        randomWeatherConditions(currentCity)
    }

    @SuppressLint("SetTextI18n")
    private fun randomWeatherConditions(city: String) {

        when (city) {
            "London" -> {
                temparature.text = "8°"
                weatherDescription.text = "Rainy"
                background.setBackgroundResource(R.drawable.background_rain)
            }
            "İstanbul" -> {
                temparature.text = "22°"
                weatherDescription.text = "Clear"
                background.setBackgroundResource(R.drawable.background_clear_night)
            }
            "Berlin" -> {
                temparature.text = "-2°"
                weatherDescription.text = "Snowy"
                background.setBackgroundResource(R.drawable.background_snow)
            }
            else -> {
                temparature.text = "6°"
                weatherDescription.text = "Foggy"
                background.setBackgroundResource(R.drawable.background_fog)
            }
        }
    }

}
