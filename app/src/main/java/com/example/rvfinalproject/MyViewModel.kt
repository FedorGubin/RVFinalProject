package com.example.rvfinalproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private val dataSource: MyDataSource = MyDataSourceImpl()
    private val _listMessages: MutableLiveData<List<MessageCard>> = MutableLiveData(dataSource.getData())
    val listMessages: LiveData<List<MessageCard>> = _listMessages

    fun onChangeSource() {
        _listMessages.value = dataSource.getData()
    }
}