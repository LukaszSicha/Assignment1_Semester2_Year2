package org.wit.festivalapp.home

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.AnkoLogger
import org.wit.festivalapp.R
import org.wit.festivalapp.artists.ArtistDetails
import org.wit.festivalapp.artists.ArtistScreen
import org.wit.festivalapp.timetable.timetableScreen

/**
Created By : Davin Fortune
Student Number : 20085000
Start Date : 09/03/2020

Tutorials Used :
https://www.youtube.com/watch?v=E4QBMxsIA5U
 **/

class HomeScreen : AppCompatActivity(), AnkoLogger {
    //BUTTONS
    lateinit var artistButton: ImageView
    lateinit var timetableButton : ImageView

    //RIGHT ANIMATION
    lateinit var firstImage : ImageView
    lateinit var firstAnimation : Animation
    lateinit var firstText : TextView

    //LEFT ANIMATION
    lateinit var secondImage : ImageView
    lateinit var secondAnimation : Animation
    lateinit var secondText : TextView

    //LOGO
    lateinit var logoImage : ImageView
    lateinit var logoAnim : Animation

    //ARTIST MODEL


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ANIMATION
           //LOGO
        logoImage = findViewById(R.id.homeButton)
        logoAnim = AnimationUtils.loadAnimation(this,R.anim.logo_animation)
        logoImage.setAnimation(logoAnim)

          //TOP IMAGE AND TEXT
        firstText = findViewById(R.id.musicText)
        firstImage = findViewById(R.id.firstImage)
        firstAnimation = AnimationUtils.loadAnimation(this,R.anim.first_image_animation)
        firstImage.setAnimation(firstAnimation)
        firstAnimation = AnimationUtils.loadAnimation(this,R.anim.first_text_animation)
        firstText.setAnimation(firstAnimation)
        // BUTTON
        firstImage.setOnClickListener{
            val firstImageIntent : Intent = Intent(applicationContext, ArtistDetails::class.java)
            startActivity(firstImageIntent)
        }

          //BOTTOM IMAGE AND TEXT
        secondText = findViewById(R.id.lifeText)
        secondImage = findViewById(R.id.secondImage)
        secondAnimation = AnimationUtils.loadAnimation(this,R.anim.second_image_animation)
        secondImage.setAnimation(secondAnimation)
        secondAnimation = AnimationUtils.loadAnimation(this,R.anim.second_text_animation)
        secondText.setAnimation(secondAnimation)


        /*Timetable Button*/
        timetableButton = findViewById(R.id.timetableButton)
        timetableButton.setOnClickListener {
            val timetableIntent : Intent = Intent(applicationContext, timetableScreen::class.java)
            startActivity(timetableIntent)
        }


        /*Artist Button*/
        artistButton = findViewById(R.id.artistButton)
        artistButton.setOnClickListener {
           val artistIntent : Intent = Intent(applicationContext, ArtistScreen::class.java)
            startActivity(artistIntent)
        }

        Picasso.with(this).load("https://pbs.twimg.com/profile_images/1238276163136561152/-VppgNF1_400x400.jpg").into(secondImage)
    }


}