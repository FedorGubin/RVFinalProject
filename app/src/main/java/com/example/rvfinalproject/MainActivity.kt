package com.example.rvfinalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rvfinalproject.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = FriendAdapter()
    private var viewModel = MyViewModel()

    //        private val friendsList = listOf(
//        R.drawable.dimasik,
//        R.drawable.lexa,
//        R.drawable.andrey,
//        R.drawable.vitek,
//        R.drawable.fedosik
//    )
//    private var index = 0
//    private var nameList = listOf(
//        "Dimasik",
//        "Lexa",
//        "Andrey",
//        "Vitek",
//        "Fedosik"
//    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        init()
    }

    fun init() {
        binding.apply {
            recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            recyclerView.adapter = adapter
            viewModel.friendsListLiveData.observe(this@MainActivity) { friends ->
                adapter.setFriends(friends)
                viewModel.indexLivedata.observe(this@MainActivity) { index ->

                }
            }
            button.setOnClickListener {
                if (viewModel.indexLivedata.value ?: 0 > 4) {
                    viewModel.indexLivedata.value = 0
                }
                val friends = Friends(
                    viewModel.friendsListLiveData[viewModel.indexLivedata.value ?: 0],
                    viewModel.friendsListLiveData[viewModel.indexLivedata.value ?: 0]
                )
                viewModel.addFriend(friends)
            }
        }
    }
}