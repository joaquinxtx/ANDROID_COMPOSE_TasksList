package com.example.composematerial3.addTasks.ui


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composematerial3.addTasks.domain.AddTaskUseCase
import com.example.composematerial3.addTasks.domain.DeleteTaskUseCase
import com.example.composematerial3.addTasks.domain.GetTasksUseCase
import com.example.composematerial3.addTasks.domain.UpdateTaskUseCase
import com.example.composematerial3.addTasks.ui.TasksUiState.Success
import com.example.composematerial3.addTasks.ui.model.TaskModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

import javax.inject.Inject


@HiltViewModel
class TasksViewModel @Inject constructor(
    private val addTaskUseCase: AddTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    getTasksUseCase: GetTasksUseCase
) : ViewModel() {

    val uiState: StateFlow<TasksUiState> = getTasksUseCase().map(::Success)
        .catch { TasksUiState.Error(it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), TasksUiState.Loading)

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog
    private val _selectedItemIndex = MutableLiveData<Int>()
    val selectedItemIndex: LiveData<Int> = _selectedItemIndex

    fun setSelectedItemIndex(index: Int) {
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

    fun onTaskCreated(task: String) {
        _showDialog.value = false


        viewModelScope.launch {
            addTaskUseCase(TaskModel(task = task))
        }
    }

    fun onShowDialogClick() {
        _showDialog.value = true
    }

    fun onShowDialogRemove(taskModel: TaskModel) {
        val tasksUiState = uiState.value
        if (tasksUiState is Success) {
            val tasks = tasksUiState.tasks
            val index = tasks.indexOfFirst { it.id == taskModel.id }
            if (index != -1) {
                setSelectedItemIndex(index)
                _showDialogRemove.value = true
            }
        }

    }

    fun onCheckBoxSelected(taskModel: TaskModel) {

        viewModelScope.launch {
            updateTaskUseCase(taskModel.copy(selected = !taskModel.selected))
        }
        taskModel.selected
    }

    fun onItemRemove(taskModel: TaskModel) {

        viewModelScope.launch {
            deleteTaskUseCase(taskModel)
            _showDialogRemove.value = false
        }
    }


}