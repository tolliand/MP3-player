package com.example.mp3player

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat



class MainActivity : AppCompatActivity() {

    var MY_PERMISSIONS_REQUEST_READ_STORAGE: Int = 0
    private var path: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startSearch(view: View?) {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    MY_PERMISSIONS_REQUEST_READ_STORAGE)
        } else {
            path = Environment.getExternalStorageDirectory().absolutePath
            val intent = Intent(this@MainActivity, FileSystem::class.java)
            intent.putExtra("path", path)
            startActivity(intent)
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_READ_STORAGE -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    path = Environment.getExternalStorageDirectory().absolutePath
                    val intent = Intent(this@MainActivity, FileSystem::class.java)
                    intent.putExtra("path", path)
                    startActivity(intent)
                } else {
                }
                return
            }
            else -> {
            }
        }
    }


}


