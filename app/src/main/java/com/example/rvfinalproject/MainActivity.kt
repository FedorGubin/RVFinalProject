package com.example.rvfinalproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rvfinalproject.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = DataAdapter()
    private val viewModel: MyViewModel by TODO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}