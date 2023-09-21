package com.example.rvfinalproject

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rvfinalproject.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = FriendAdapter()
    private val viewModel by viewModels<MyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        observers()
        with (binding) {
            recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            recyclerView.adapter = adapter

            button.setOnClickListener {
                viewModel.addFriend()
            }
        }
    }

    private fun observers() {
        viewModel.friendsListLiveData.observe(this@MainActivity) { friends ->
            adapter.setFriends(friends)
        }
    }
}