package com.example.mp3player

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import androidx.core.view.MotionEventCompat
import com.google.android.exoplayer2.util.Util


class TrackList : AppCompatActivity() {

    //private lateinit var playerView: PlayerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track_list)

        val arguments = intent.extras
        val path = arguments!!.get("path")!!.toString()


        val intent = Intent(this, AudioPLayerService::class.java)
        intent.putExtra("path", path)
        Util.startForegroundService(this,intent)
/*
        val uri: Uri = Uri.parse(path)
        player = ExoPlayerFactory.newSimpleInstance(this, DefaultTrackSelector())
        val dataSourceFactory = DefaultDataSourceFactory(this, getUserAgent(this, "MP3 player"))
        val concatenatingMediaSource = ConcatenatingMediaSource()
        val mediaSource: MediaSource = ExtractorMediaSource.Factory(dataSourceFactory).createMediaSource(uri)
        concatenatingMediaSource.addMediaSource(mediaSource)
        player.prepare(concatenatingMediaSource)
        player.playWhenReady
        */
/*
               player = ExoPlayerFactory.newSimpleInstance(this)
               playerView = findViewById(R.id.playerView)
               playerView.player = player

               // Produces DataSource instances through which media data is loaded.
               val dataSourceFactory = DefaultDataSourceFactory(
                   this,
                   getUserAgent(this, "MP3 player")
               )*/

// This is the MediaSource representing the media to be played.
        /*val audioSource = ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(mp4VideoUri)
        player.prepare(audioSource)*/


    }


    override fun onTouchEvent(event: MotionEvent): Boolean {

        return when (MotionEventCompat.getActionMasked(event)) {
            MotionEvent.ACTION_MOVE -> {
                onBackPressed()
                true
            }
            else -> super.onTouchEvent(event)
        }
    }

}
