package com.example.mvvmdemo.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmdemo.data.api.ApiError
import com.example.mvvmdemo.data.api.ApiResponse
import com.example.mvvmdemo.data.model.Todo
import com.example.mvvmdemo.data.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MainViewModel: ViewModel() {

    fun getTodoForUserId(id:Int): LiveData<ApiResponse> {
        return liveData(Dispatchers.IO) {
            try {
                val todo = TodoRepository.getSpecificTodo(id)
                emit(ApiResponse(todo))
            }catch (ex: Exception)  {
                emit(ApiResponse(ApiError(ex)))
            }
        }
    }

}