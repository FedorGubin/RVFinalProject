package com.example.rvfinalproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private val dataSource: FriendsDataSource = FriendsDataSourceImpl()
    private val _friendsListLiveData = MutableLiveData<List<Friend>>()
    val friendsListLiveData: LiveData<List<Friend>> = _friendsListLiveData

    fun addFriend() {
        _friendsListLiveData.value =_friendsListLiveData.value?.let { friends ->
            friends + dataSource.getFriendsByIndex(friends.size % 5)
        } ?: listOf(dataSource.getFriendsByIndex(0))
    }
}