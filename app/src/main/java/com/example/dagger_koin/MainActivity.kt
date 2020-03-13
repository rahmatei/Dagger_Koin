package com.example.dagger_koin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dagger_koin.dagger.daggerActivity
import com.example.dagger_koin.koin.KoinActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnDagger.setOnClickListener {
            val intent = Intent(this,daggerActivity::class.java)
            startActivity(intent)
        }
        btnKoin.setOnClickListener {
            val intent = Intent(this,KoinActivity::class.java)
            startActivity(intent)
        }
    }
}
