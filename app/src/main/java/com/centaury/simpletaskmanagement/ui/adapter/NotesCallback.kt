package com.centaury.simpletaskmanagement.ui.adapter

import com.centaury.simpletaskmanagement.domain.model.NotesModel

interface NotesCallback {
    fun onItemClicked(notesModel: NotesModel)
}