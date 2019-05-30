package com.example.mp3player

import android.app.Service
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.IBinder
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ConcatenatingMediaSource
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.PlayerNotificationManager
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util.getUserAgent

class AudioPLayerService : Service() {

    private lateinit var player: SimpleExoPlayer
    var path: String =""

    override fun onBind(intent: Intent?): IBinder? {
        val arguments = intent!!.extras
        path = arguments!!.get("path")!!.toString()
        return null
    }

    override fun onCreate(){

        val context: Context = this
        val uri: Uri = Uri.parse(path)
        player = ExoPlayerFactory.newSimpleInstance(this, DefaultTrackSelector())
        val dataSourceFactory = DefaultDataSourceFactory(this, getUserAgent(this, "MP3 player"))
        val concatenatingMediaSource = ConcatenatingMediaSource()
        val mediaSource: MediaSource = ExtractorMediaSource.Factory(dataSourceFactory).createMediaSource(uri)
        concatenatingMediaSource.addMediaSource(mediaSource)
        player.prepare(concatenatingMediaSource)
        player.playWhenReady

        /*val playerNotificationManager = PlayerNotificationManager.createWithNotificationChannel(
            context, PLAYBACK_CHANNEL_ID, R.string.playback_channel_name
        )*/
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }
}