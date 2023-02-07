package com.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsapp.NewsActivity
import com.example.newsapp.R
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.utils.showAnotherActivity
import com.example.utils.showToolbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        this@MainActivity.showAnotherActivity(NewsActivity::class.java)
    }

    private fun setupToolbar() {
        setSupportActionBar(
            binding.toolbar.root.showToolbar(
                "NickelFox Assignment",
                android.R.color.white,
                R.color.purple_700
            )
        )
    }
}