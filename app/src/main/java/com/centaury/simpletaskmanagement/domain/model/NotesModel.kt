package com.centaury.simpletaskmanagement.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class NotesModel(
    val id: Int,
    val title: String,
    val date: Date
) : Parcelable
