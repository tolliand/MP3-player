package com.example.mp3player

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
/*
    private lateinit var playerView: PlayerView
    private lateinit var player: SimpleExoPlayer
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

 /*       player = ExoPlayerFactory.newSimpleInstance(this)
        playerView = findViewById(R.id.playerView)
        playerView.player = player

        // Produces DataSource instances through which media data is loaded.
        val dataSourceFactory = DefaultDataSourceFactory(
            this,
            getUserAgent(this, "MP3 player")
        )

       val audioSource =*/
// This is the MediaSource representing the media to be played.
        /*val audioSource = ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(mp4VideoUri)
        player.prepare(audioSource)*/
    }

    fun startSearch(view: View?) {
        val intent = Intent(this@MainActivity, FileSystem::class.java)
        startActivity(intent)
    }
/*
    override fun onStop() {
        super.onStop()

        playerView.player = null
        player.release()
        //player = null
    }
    */


}


