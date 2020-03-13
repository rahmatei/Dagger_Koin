package com.example.dagger_koin.koin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.dagger_koin.R
import kotlinx.android.synthetic.main.activity_koin.*
import org.koin.android.viewmodel.ext.android.viewModel

class KoinActivity : AppCompatActivity() {

    val vm:KoinViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_koin)
        vm.GetLiveResponseSharei().observe(this, Observer {

        })
     /*   btngetsharei.setOnClickListener {
            vm.GetShareidata(edtCity.text.toString(),edtCountry.text.toString(),"8")
        }*/
    }
}
