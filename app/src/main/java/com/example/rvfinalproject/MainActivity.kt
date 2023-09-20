package com.example.rvfinalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rvfinalproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = FriendAdapter()
    private val friendsList = listOf(
        R.drawable.dimasik,
        R.drawable.lexa,
        R.drawable.andrey,
        R.drawable.vitek,
        R.drawable.fedosik
    )
    private var index = 0
    private var nameList = listOf(
        "Dimasik",
        "Lexa",
        "Andrey",
        "Vitek",
        "Fedosik"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    fun init() {
        binding.apply {
            recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            recyclerView.adapter = adapter
            button.setOnClickListener {
                if (index > 4) index = 0
                val friends = Friends(friendsList[index], nameList[index])
                adapter.addCard(friends)
                index++
            }
        }
    }
}