package com.example.mp3player

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.TextView
import android.widget.AdapterView





class FileSystem : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_system)

        val listView: ListView = findViewById(R.id.listView)

        val s: Array<String> = arrayOf("123", "456")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, s)

        listView.adapter = adapter

        listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, itemClicked, position, id ->
                val intent = Intent(this@FileSystem, TrackList::class.java)
                startActivity(intent)
            }
    }
}
