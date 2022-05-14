package com.whydanu.informasicovid19.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.whydanu.informasicovid19.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplascreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splascreen)

        supportActionBar?.hide()

        CoroutineScope(Dispatchers.Main).launch{
            delay(7000L)
            startActivity(Intent(this@SplascreenActivity,MainActivity::class.java))
            finish()
        }

    }
}