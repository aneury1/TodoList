package com.aneury1.todolist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
 /////    private @Inject var dataset: Dataset
) :ViewModel(){

    val liveData = MutableLiveData<String>("no data")

    val todoList  = MutableLiveData<List<TodoModel>>(null)

    init{
      ///  liveData.postValue(dataset.CONSTANT)
    }
}

