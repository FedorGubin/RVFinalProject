package com.example.rvfinalproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private var dataSource: MyDataSource = MyDataSourceSMSImpl()
    private val _listMessages: MutableLiveData<List<MessageCard>> = MutableLiveData(dataSource.getData())
    val listMessages: LiveData<List<MessageCard>> = _listMessages

    fun onChangeSource() {
        // TODO(Как происходит подмена источников данных. Почему разные колассы могут быть приравнены
        //  к одной и той же переменной. Почему when не попросил установить else)
        dataSource = when (dataSource) {
            is MyDataSourceSMSImpl -> MyDataSourceEmailImpl()
            is MyDataSourceEmailImpl -> MyDataSourceSMSImpl()
        }
        _listMessages.value = dataSource.getData()
    }
}