package com.xiaoyu.videoplayer

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import kotlinx.android.synthetic.main.activity_play.*


class PlayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        val name = intent.getStringExtra("name")
        val uri = intent.getStringExtra("uri")
        println("name: $name  uir: $uri")
        val player = SimpleExoPlayer.Builder(applicationContext).build()
        playerView.player = player
        val mediaItem: MediaItem =
            MediaItem.fromUri(Uri.parse("https://storage.googleapis.com/wvmedia/2019/clear/av1/24/webm/llama_av1_480p_400.webm"))
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()

    }
}