package com.whydanu.informasicovid19.Activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.whydanu.informasicovid19.R
import com.whydanu.informasicovid19.api.RetrofitClient
import com.whydanu.informasicovid19.model.IndonesiaResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btntentang : Button
    private lateinit var  btnprofil : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // val view = binding.root
        //tombol pindah tentang
        btntentang = findViewById(R.id.btntentang)
        btntentang.setOnClickListener(this)

        //tombol pindah profil
        btnprofil = findViewById(R.id.btnprofil)
        btnprofil.setOnClickListener(this)



        showIndonesia()
        btnProvince.setOnClickListener{
            Intent(this@MainActivity,ProvinceActivity::class.java).also {
                startActivity(it)
            }
        }
        btnpetasebaran.setOnClickListener{
            val i =Intent(Intent.ACTION_VIEW, Uri.parse("https://covid19.go.id/peta-sebaran"))
            startActivity(i)
        }

    }

    private fun showIndonesia() {
        RetrofitClient.instance.getIndonesia()
            .enqueue(object : Callback<ArrayList<IndonesiaResponse>> {
                override fun onFailure(call: Call<ArrayList<IndonesiaResponse>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<ArrayList<IndonesiaResponse>>,
                    response: Response<ArrayList<IndonesiaResponse>>
                ) {

                    val indonesiaResponse = response.body()?.get(0)
                    val positive = indonesiaResponse?.positif
                    val hospital = indonesiaResponse?.dirawat
                    val recoveri = indonesiaResponse?.sembuh
                    val death = indonesiaResponse?.meninggal

                    tvPositive.text = positive
                    tvHospitalized.text = hospital
                    tvRecover.text= recoveri
                    tvDeath.text = death

                }


            })

    }

    override fun onClick(v: View) {

        when(v.id){
            R.id.btntentang ->{
            val tn= Intent(this@MainActivity,TentangActivity::class.java)
                startActivity(tn)

            }


        }
        when(v.id){
            R.id.btnprofil ->{
                val pr = Intent ( this@MainActivity, ProfilActivity::class.java)
                startActivity(pr)
            }
        }
    }
}