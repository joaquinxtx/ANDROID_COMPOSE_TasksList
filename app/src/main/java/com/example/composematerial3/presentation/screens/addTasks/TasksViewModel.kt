package com.example.composematerial3.presentation.screens.addTasks


import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composematerial3.domain.Resource
import com.example.composematerial3.domain.model.TaskModel

import com.example.composematerial3.domain.useCase.*
import com.example.composematerial3.presentation.screens.addTasks.mapper.toTask
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

import javax.inject.Inject


@HiltViewModel
class TasksViewModel @Inject constructor(
    private val taskUseCase: CrudUseCase
) : ViewModel() {


    private val _taskState = MutableStateFlow(TaskCreateState())
    val taskState: StateFlow<TaskCreateState> = _taskState.asStateFlow()

    var taskResponse by mutableStateOf<Resource<List<TaskModel>>?>(null)
        private set
    var taskCreatedResponse by mutableStateOf<Resource<TaskModel>?>(null)

    var deleteTaskResponse by mutableStateOf<Resource<Unit>?>(value = null)
        private set


    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

    private val _selectedItemIndex = MutableLiveData<Int>()
    val selectedItemIndex: LiveData<Int> = _selectedItemIndex

    init {
        getTask()
    }

    private fun setSelectedItemIndex(index: Int) {
        _selectedItemIndex.value = index
    }


    private val _showDialogRemove = MutableLiveData<Boolean>()
    val showDialogRemove: LiveData<Boolean> = _showDialogRemove


    fun onDialogClose() {
        _showDialog.value = false
    }

    fun onDialogRemoveClose() {
        _showDialogRemove.value = false

    }

    fun onTaskCreated() {
        _showDialog.value = false
        viewModelScope.launch {
            taskCreatedResponse = Resource.Loading
            val result = taskUseCase.addTask(_taskState.value.toTask())
            taskCreatedResponse = result
        }
    }

    fun onShowDialogClick() {
        _showDialog.value = true
    }

    fun onShowDialogRemove(taskModel: TaskModel) {
        val tasks = taskResponse?.let { resource ->
            if (resource is Resource.Success) {
                resource.data
            } else {
                null
            }
        }
        if (tasks != null) {
            val index = tasks.indexOfFirst { it.id == taskModel.id }
            if (index != -1) {
                setSelectedItemIndex(index)
                _showDialogRemove.value = true
            }
        }
    }

    fun onCheckBoxSelected(taskModel: TaskModel) = viewModelScope.launch {
        val tasks = taskResponse?.let { resource ->
            if (resource is Resource.Success) {
                resource.data
            } else {
                null
            }
        }
        if (tasks != null) {
            val index = tasks.indexOfFirst { it.id == taskModel.id }
            if (index != -1) {
                setSelectedItemIndex(index)
                taskModel.selected = !taskModel.selected
            }
        }

        Log.d("vm", "${taskModel.selected}")
    }


    fun onTaskInput(task: String) {
        _taskState.value = _taskState.value.copy(task = task)
    }

    private fun getTask() = viewModelScope.launch {
        taskResponse = Resource.Loading
        taskUseCase.getTasks().collect { result ->
            taskResponse = Resource.Success(result)
        }
    }

    fun onItemRemove(task: TaskModel) {
        viewModelScope.launch {
            deleteTask(task.id.toString())
            _showDialogRemove.value = false
        }
    }

    private fun deleteTask(id: String) = viewModelScope.launch {
        deleteTaskResponse = Resource.Loading
        val result = taskUseCase.deleteTask(id)
        deleteTaskResponse = result
    }
}
