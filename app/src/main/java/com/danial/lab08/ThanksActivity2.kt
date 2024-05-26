package com.danial.lab08

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.danial.lab08.databinding.ActivityMainBinding
import com.danial.lab08.databinding.ActivityThanks2Binding

class ThanksActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityThanks2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThanks2Binding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        binding.nameTextView.text = intent.getStringExtra("name")
        binding.phoneTextView.text = intent.getStringExtra("phone")
        binding.sizeVerifTextView.text = intent.getStringExtra("size")
        binding.pickupDateVerifTextView.text = intent.getStringExtra("date")
        binding.pickupTimeVerifTextView.text = intent.getStringExtra("time")


        binding.ratingBtn.setOnClickListener {
            binding.ratingTextView.text = binding.ratingBar.rating.toString()
        }


    }

}