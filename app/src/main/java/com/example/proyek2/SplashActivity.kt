package com.example.proyek2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.proyek2.databinding.ActivitySplashBinding
import com.example.proyek2.model.SharedPreferences
import com.example.proyek2.util.Constants.EMAIL
import com.example.proyek2.util.Constants.PASS
import com.example.proyek2.util.Constants.PREFS_NAME

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


        sharedPreferences = SharedPreferences(this)
        val name = sharedPreferences.getData(EMAIL)
        val lastNAme = sharedPreferences.getData(PASS)
        val Age = sharedPreferences.getData(PREFS_NAME)
        intent(name, lastNAme, Age)

    }

    private fun intent(email: String?, pass: String?, age : String?) {

        object : CountDownTimer(2000, 1000) {

            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                if (email == null && pass == null) {
                    Intent(this@SplashActivity, Loging_Activity::class.java).also {
                        Toast.makeText(this@SplashActivity, "$email $pass ${age}", Toast.LENGTH_SHORT)
                            .show()
                        startActivity(it)
                        finish()
                    }
                } else {
                    Intent(this@SplashActivity, MainActivity::class.java).also {
                        startActivity(it)
                        finish()
                    }
                }
            }
        }.start()

    }
    }