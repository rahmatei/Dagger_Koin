package com.example.dagger_koin.dagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dagger_koin.R
import kotlinx.android.synthetic.main.activity_dagger.*

class daggerActivity : AppCompatActivity() {

    lateinit var viewModel: daggerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger)

        val factory = DaggerdComponent.create().ProvideVMDaggerFactory()
        viewModel=ViewModelProvider(this,factory).get(daggerViewModel::class.java)

        viewModel.GetLiveResponseSharei().observe(this, Observer {
            Toast.makeText(this,it.sunrise, Toast.LENGTH_LONG).show()
            txtsunrise.text=it.sunrise
            txtsunset.text=it.sunset
        })

        btngetsharei.setOnClickListener {
            viewModel.GetShareidata(edtCity.text.toString(),edtCountry.text.toString(),"8")
        }
    }
}
