package org.wit.festivalapp.home

import android.content.Intent
import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import org.wit.festivalapp.R
import org.wit.festivalapp.artists.artistScreen
import org.wit.festivalapp.image.imageScreen
import org.wit.festivalapp.location.locationScreen
import org.wit.festivalapp.timetable.timetableScreen

/**
Created By : Davin Fortune
Student Number : 20085000
Start Date : 09/03/2020

Tutorials Used :
https://www.youtube.com/watch?v=E4QBMxsIA5U
 **/

class homeScreen : AppCompatActivity() {

    lateinit var artistButton: ImageView
    lateinit var timetableButton : ImageView
    lateinit var imageButton : ImageView
    lateinit var locationButton : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Timetable Button*/
        timetableButton = findViewById(R.id.timetableButton)
        timetableButton.setOnClickListener {
            val timetableIntent : Intent = Intent(applicationContext, timetableScreen::class.java)
            startActivity(timetableIntent)
        }

        /*Image Button*/
        imageButton = findViewById(R.id.imageButton)
        imageButton.setOnClickListener{
            val imageIntent : Intent = Intent(applicationContext, imageScreen::class.java)
            startActivity(imageIntent)
        }


        /*Location Button*/
        locationButton = findViewById(R.id.locationButton)
        locationButton.setOnClickListener {
            val locationIntent : Intent = Intent(applicationContext, locationScreen::class.java)
            startActivity(locationIntent)
        }

        /*Artist Button*/
        artistButton = findViewById(R.id.artistButton)
        artistButton.setOnClickListener {
           val artistIntent : Intent = Intent(applicationContext, artistScreen::class.java)
            startActivity(artistIntent)
        }

    }


}