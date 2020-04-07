package org.wit.festivalapp.artists

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_artist_add.*
import kotlinx.android.synthetic.main.activity_artist_screen.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast
import org.wit.festivalapp.R
import org.wit.festivalapp.home.HomeScreen
import org.wit.festivalapp.main.MainApp
import org.wit.festivalapp.timetable.timetableScreen

class ArtistScreen : AppCompatActivity(), ArtistListener, AnkoLogger {

    lateinit var app : MainApp

    lateinit var timetableButton : ImageView
    lateinit var homeButton : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_screen)
        app = application as MainApp
        if(app.artistArray.findAll().toString() == "[]") {
            app.artistArray.create(
                ArtistModel(
                    0,
                    "Westlife",
                    "Heinken Tent",
                    "Pop",
                    "6:30",
                    "https://i.pinimg.com/474x/a7/a1/68/a7a1684537e14e38d47e3d9b401dcf84.jpg"
                )
           )
       }

        if(intent.hasExtra("add_artist")){
           var addArtist = intent.extras.getParcelable<ArtistModel>("add_artist")
           app.artistArray.create(ArtistModel(0,addArtist.artistName,addArtist.artistArena,addArtist.artistGenre,addArtist.artistTime,addArtist.artistImage))
        }

        /*Home Button*/
        homeButton = findViewById(R.id.homeButton)
        homeButton.setOnClickListener {
            finish()
            val moveIntent : Intent = Intent(applicationContext, HomeScreen::class.java)
            startActivity(moveIntent)
        }

        /*Timetable Button*/
        timetableButton = findViewById(R.id.timetableButton)
        timetableButton.setOnClickListener {
            finish()
            val timetableIntent : Intent = Intent(applicationContext, timetableScreen::class.java)
            startActivity(timetableIntent)
        }

        //ARTIST CODE
        addArtistButton.setOnClickListener{
        val artistIntent : Intent = Intent(applicationContext, AddArtist::class.java)
           startActivity(artistIntent)
        }

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        loadArtists()
    }

    override fun onArtistClick(artist: ArtistModel) {
        var detailsScreen : Intent = Intent(applicationContext, ArtistDetails::class.java)
        startActivity(detailsScreen.putExtra("details_artist", artist))
    }
    private fun loadArtists(){
        showArtists(app.artistArray.findAll())
    }

    fun showArtists (artists : List<ArtistModel>){
        recyclerView.adapter = ArtistAdapter(artists, this)
        recyclerView.adapter?.notifyDataSetChanged()
    }
}
