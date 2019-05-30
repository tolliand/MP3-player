package com.example.mp3player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import androidx.core.view.MotionEventCompat

class TrackList : AppCompatActivity() {
    /*
        private lateinit var playerView: PlayerView
        private lateinit var player: SimpleExoPlayer
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track_list)

        val arguments = intent.extras
        val path = arguments!!.get("path")

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


    override fun onTouchEvent(event: MotionEvent): Boolean {

        return when (MotionEventCompat.getActionMasked(event)) {
            MotionEvent.ACTION_DOWN -> {
                true
            }
            else -> super.onTouchEvent(event)
        }
    }

    /*
    override fun onStop() {
        super.onStop()

        playerView.player = null
        player.release()
    }
    */
}
