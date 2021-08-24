package com.recep.jedidroidsweather

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.util.*

class MainActivity : AppCompatActivity() {

    val cityList = mutableListOf("Londra", "İstanbul", "Berlin", "Atina")
    val weatherConditionList = mutableListOf("Foggy", "Snowy", "Clear", "Rainy")

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

        val c = Calendar.getInstance()
        val cDayName = c.get(Calendar.DAY_OF_WEEK)
        val date = SimpleDateFormat("dd MMM yyyy").format(c.getTime())
        val fullDateInfo = "${getDayName(cDayName)}, $date"

        dateInformation.text = fullDateInfo
    }

    private fun getDayName(dayOfWeek: Int): String {
        return when (dayOfWeek) {
            0 -> "Pazar"
            1 -> "Pazartesi"
            2 -> "Salı"
            3 -> "Çarşamba"
            4 -> "Perşembe"
            5 -> "Cuma"
            else -> "Cumartesi"
        }
    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        randomCity()
    }

    private fun randomCity() {
        cityList.shuffle()
        var currentCity = cityList[(0..3).random()]
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
