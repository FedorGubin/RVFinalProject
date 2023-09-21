package com.example.rvfinalproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
private val _friendsListLiveData = MutableLiveData<List<Friends>>(mutableListOf())
    val friendsListLiveData: LiveData<List<Friends>> = _friendsListLiveData
    private val _indexLivedata = MutableLiveData<Int>(0)
    val indexLivedata: LiveData<Int> = _indexLivedata

    fun addFriend(friend: Friends) {
        val currentList = _friendsListLiveData.value?.toMutableList() ?: mutableListOf()
        currentList.add(friend)
        _friendsListLiveData.value = currentList
        _indexLivedata.value = (_indexLivedata.value ?: 0) + 1
    }

}