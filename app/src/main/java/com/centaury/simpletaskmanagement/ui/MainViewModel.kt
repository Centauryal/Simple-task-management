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

    private val _getAllNotes = MutableLiveData<List<NotesModel>>()
    val getAllNotes: LiveData<List<NotesModel>>
        get() = _getAllNotes

    private val _getNoteById = MutableLiveData<NotesModel>()
    val getNoteById: LiveData<NotesModel>
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
            _getNoteById.postValue(simpleTaskRepository.getNoteById(id))
        }
    }

    fun setInsertNote(notesModel: NotesModel) {
        viewModelScope.launch {
            _insertNote.postValue(simpleTaskRepository.insertNote(notesModel))
        }
    }

    fun setUpdateNote(notesModel: NotesModel) {
        viewModelScope.launch {
            _updateNote.postValue(simpleTaskRepository.updateNote(notesModel))
        }
    }

    fun deleteNote(notesModel: NotesModel) {
        viewModelScope.launch {
            _deleteNote.postValue(simpleTaskRepository.deleteNote(notesModel))
        }
    }

    fun deleteAllNotes() {
        viewModelScope.launch {
            _deleteAllNotes.postValue(simpleTaskRepository.deleteAllNotes())
        }
    }
}