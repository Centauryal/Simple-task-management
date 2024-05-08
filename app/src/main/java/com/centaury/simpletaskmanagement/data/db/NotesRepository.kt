package com.centaury.simpletaskmanagement.data.db

class NotesRepository(private val noteDao: NoteDao) : NotesEntityData {
    override fun getAllNotes(): List<NoteEntity> = noteDao.allNotes()

    override fun getNoteById(id: Int): NoteEntity = noteDao.getNoteById(id)

    override fun insertNote(note: NoteEntity) = noteDao.insert(note)

    override fun updateNote(note: NoteEntity) = noteDao.update(note)

    override fun deleteNote(note: NoteEntity) = noteDao.delete(note)

    override fun deleteAllNotes() = noteDao.deleteAll()
}