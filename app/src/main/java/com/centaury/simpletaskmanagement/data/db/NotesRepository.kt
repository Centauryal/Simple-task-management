package com.centaury.simpletaskmanagement.data.db

import androidx.lifecycle.LiveData
import java.util.concurrent.ExecutionException

class NotesRepository(private val appDatabase: AppDatabase): NotesEntityData {
    override fun getAllNotes(): LiveData<List<NoteEntity>> = appDatabase.noteDao().allNotes

    override fun getNoteById(id: Int): NoteEntity = appDatabase.noteDao().getNoteById(id)

    override fun insertNote(note: NoteEntity) = appDatabase.noteDao().insert(note)

    override fun updateNote(note: NoteEntity) = appDatabase.noteDao().update(note)

    override fun deleteNote(note: NoteEntity) = appDatabase.noteDao().delete(note)

    override fun deleteAllNotes() = appDatabase.noteDao().deleteAll()
}