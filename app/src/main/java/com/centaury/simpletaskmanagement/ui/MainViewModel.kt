package com.centaury.simpletaskmanagement.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.centaury.simpletaskmanagement.domain.SimpleTaskRepository
import com.centaury.simpletaskmanagement.domain.model.NotesModel
import kotlinx.coroutines.launch

class MainViewModel(
    private val simpleTaskRepository: SimpleTaskRepository,
) : ViewModel() {

    private val _getAllNotes = MutableLiveData<Any>()
    val getAllNotes: LiveData<Any>
        get() = _getAllNotes

    private val _getNoteById = MutableLiveData<Any>()
    val getNoteById: LiveData<Any>
        get() = _getNoteById

    private val _insertNote = MutableLiveData<Any>()
    val insertNote: LiveData<Any>
        get() = _insertNote

    private val _updateNote = MutableLiveData<Any>()
    val updateNote: LiveData<Any>
        get() = _updateNote

    private val _deleteNote = MutableLiveData<Any>()
    val deleteNote: LiveData<Any>
        get() = _deleteNote

    private val _deleteAllNotes = MutableLiveData<Any>()
    val deleteAllNotes: LiveData<Any>
        get() = _deleteAllNotes

    init {
        getListNotes()
    }

    private fun getListNotes() {
        viewModelScope.launch {
            _getAllNotes.postValue(simpleTaskRepository.getAllNotes())
        }
    }

    fun getNoteById(id: Int) {
        viewModelScope.launch {
            _getAllNotes.postValue(simpleTaskRepository.getNoteById(id))
        }
    }

    fun setInsertNote(notesModel: NotesModel) {
        viewModelScope.launch {
            _getAllNotes.postValue(simpleTaskRepository.insertNote(notesModel))
        }
    }

    fun setUpdateNote(notesModel: NotesModel) {
        viewModelScope.launch {
            _getAllNotes.postValue(simpleTaskRepository.updateNote(notesModel))
        }
    }

    fun deleteNote(notesModel: NotesModel) {
        viewModelScope.launch {
            _getAllNotes.postValue(simpleTaskRepository.deleteNote(notesModel))
        }
    }

    fun deleteAllNotes() {
        viewModelScope.launch {
            _getAllNotes.postValue(simpleTaskRepository.deleteAllNotes())
        }
    }
}