package com.centaury.simpletaskmanagement.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "note")
    val title: String,

    @ColumnInfo(name = "status")
    val status: String,

    @ColumnInfo(name = "timestamp")
    val date: Date = Date(),
)