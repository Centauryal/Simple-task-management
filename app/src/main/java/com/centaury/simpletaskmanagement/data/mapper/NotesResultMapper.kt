package com.centaury.simpletaskmanagement.data.mapper

import com.centaury.simpletaskmanagement.data.db.NoteEntity
import com.centaury.simpletaskmanagement.domain.model.NotesModel

class NotesResultMapper {
    fun transformNotes(noteEntity: List<NoteEntity>): List<NotesModel> =
        noteEntity.map { it.toNotes() }

    fun transformEntityNoteById(noteEntity: NoteEntity): NotesModel = noteEntity.toNotes()

    fun transformNoteToEntity(noteModel: NotesModel): NoteEntity =
        NoteEntity(
            noteModel.id,
            noteModel.title,
            noteModel.date,
        )

    private fun NoteEntity.toNotes() = NotesModel(
        id = this.id,
        title = this.title,
        date = this.date
    )
}