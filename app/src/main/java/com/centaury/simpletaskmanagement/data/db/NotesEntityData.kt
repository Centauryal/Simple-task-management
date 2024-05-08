package com.centaury.simpletaskmanagement.data.db

interface NotesEntityData {

    fun getAllNotes(): List<NoteEntity>

    fun getNoteById(id: Int): NoteEntity

    fun insertNote(note: NoteEntity)

    fun updateNote(note: NoteEntity)

    fun deleteNote(note: NoteEntity)

    fun deleteAllNotes()
}