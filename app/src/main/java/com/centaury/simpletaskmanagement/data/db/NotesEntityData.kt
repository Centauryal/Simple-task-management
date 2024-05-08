package com.centaury.simpletaskmanagement.data.db

import androidx.lifecycle.LiveData

interface NotesEntityData {

    fun getAllNotes(): LiveData<List<NoteEntity>>

    fun getNoteById(id: Int): NoteEntity

    fun insertNote(note: NoteEntity)

    fun updateNote(note: NoteEntity)

    fun deleteNote(note: NoteEntity)

    fun deleteAllNotes()
}