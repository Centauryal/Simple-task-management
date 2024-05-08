package com.centaury.simpletaskmanagement.data

import com.centaury.simpletaskmanagement.data.db.NotesRepository
import com.centaury.simpletaskmanagement.data.mapper.NotesResultMapper
import com.centaury.simpletaskmanagement.domain.SimpleTaskRepository
import com.centaury.simpletaskmanagement.domain.model.NotesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SimpleTaskEntityRepository(
    private val notesRepository: NotesRepository,
    private val notesResultMapper: NotesResultMapper,
): SimpleTaskRepository {
    override suspend fun getAllNotes(): List<NotesModel> {
        return withContext(Dispatchers.IO) {
            notesResultMapper.transformNotes(notesRepository.getAllNotes())
        }
    }

    override suspend fun getNoteById(id: Int): NotesModel {
        return withContext(Dispatchers.IO) {
            notesResultMapper.transformEntityNoteById(
                notesRepository.getNoteById(id)
            )
        }
    }

    override suspend fun insertNote(note: NotesModel) {
        return withContext(Dispatchers.IO) {
            notesRepository.insertNote(notesResultMapper.transformNoteToEntity(note))
        }
    }

    override suspend fun updateNote(note: NotesModel) {
        return withContext(Dispatchers.IO) {
            notesRepository.updateNote(notesResultMapper.transformNoteToEntity(note))
        }
    }

    override suspend fun deleteNote(note: NotesModel) {
        return withContext(Dispatchers.IO) {
            notesRepository.deleteNote(notesResultMapper.transformNoteToEntity(note))
        }
    }

    override suspend fun deleteAllNotes() {
        return withContext(Dispatchers.IO) {
            notesRepository.deleteAllNotes()
        }
    }
}