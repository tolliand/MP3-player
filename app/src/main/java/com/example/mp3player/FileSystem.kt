package com.example.mp3player

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.ListView
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.widget.TextView
import java.io.File

class FileSystem : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_system)

        val arguments = intent.extras
        val path = arguments!!.get("path")!!.toString()

        val listView: ListView = findViewById(R.id.listView)

        var s: Array<String> = emptyArray()

        File(path).listFiles().forEach { s += it.name }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, s)

        listView.adapter = adapter

        listView.onItemClickListener =
            AdapterView.OnItemClickListener { _, itemClicked, _, _ ->
                val ss: TextView = itemClicked as TextView
                /*
                if (ss.text == "*.mp3"){
                    val intent = Intent(this@FileSystem, TrackList::class.java)
                    intent.putExtra("audio", path + "/" + ss.text)
                    intent.putExtra("path", path)
                    startActivity(intent)
                } else {
                    val intent = Intent(this@FileSystem, FileSystem::class.java)
                    intent.putExtra("path", path + "/" + ss.text)
                    startActivity(intent)
                }
                */
                val intent = Intent(this@FileSystem, TrackList::class.java)
                intent.putExtra("audio", path + "/" + ss.text)
                intent.putExtra("path", path + "/" + ss.text)
                startActivity(intent)
            }
    }
}
