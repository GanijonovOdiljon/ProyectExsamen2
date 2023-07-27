package com.example.proyek2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyek2.databinding.ActivityMainBinding
import com.example.proyek2.model.SharedPreferences
import com.example.proyek2.util.Constants

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreference = SharedPreferences(this)

        val name = sharedPreference.getData(Constants.EMAIL)
        val LastName = sharedPreference.getData(Constants.PASS)
        val Age = sharedPreference.getData(Constants.PREFS_NAME)

        binding.name.text = name
        binding.lastName.text = LastName
        binding.Age.text = Age

        binding.ochirish.setOnClickListener {
            sharedPreference.clear()
            finish()
        }
    }
}