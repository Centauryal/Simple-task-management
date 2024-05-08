package com.centaury.simpletaskmanagement.domain

import androidx.lifecycle.LiveData
import com.centaury.simpletaskmanagement.domain.model.NotesModel

interface SimpleTaskRepository {
    suspend fun getAllNotes(): LiveData<List<NotesModel>>

    suspend fun getNoteById(id: Int): NotesModel

    suspend fun insertNote(note: NotesModel)

    suspend fun updateNote(note: NotesModel)

    suspend fun deleteNote(note: NotesModel)

    suspend fun deleteAllNotes()
}