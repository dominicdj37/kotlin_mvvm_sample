package com.example.mvvmdemo.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmdemo.data.model.Todo
import com.example.mvvmdemo.data.repository.TodoRepository
import kotlinx.coroutines.Dispatchers

class mainViewModel: ViewModel() {

    fun getTodoForUserId(id:Int): LiveData<Todo> {
        return liveData(Dispatchers.IO) {
            val todo = TodoRepository.getSpecificTodo(id)
            emit(todo)
        }
    }

}