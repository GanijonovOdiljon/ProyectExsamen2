package com.example.proyek2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proyek2.databinding.ActivityLogingBinding
import com.example.proyek2.model.SharedPreferences

class Loging_Activity : AppCompatActivity() {

    private lateinit var binding: ActivityLogingBinding
    private lateinit var sharedPreference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreference = SharedPreferences(this)

        binding.buttonEdit.setOnClickListener {
            val name = binding.name.text.toString().trim()
            val lastName = binding.lastname.text.toString().trim()
            val Age = binding.Age.text.toString().trim()

            sharedPreference.saveData(name, lastName, Age)

            if (name.isNotBlank() && lastName.isNotBlank() && Age.isNotBlank()) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
                Toast.makeText(this, "Malumotlar saqlandi!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Malumotlarni to'g'ri kiriting!!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}