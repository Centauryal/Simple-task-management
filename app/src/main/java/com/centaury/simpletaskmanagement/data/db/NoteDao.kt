package com.centaury.simpletaskmanagement.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update

@Dao
interface NoteDao {

    @get:Query("SELECT * FROM notes ORDER BY id DESC")
    val allNotes: LiveData<List<NoteEntity>>

    @Transaction
    @Query("SELECT * FROM notes WHERE id=:id")
    fun getNoteById(id: Int): NoteEntity

    @Query("SELECT * FROM notes WHERE id=:id")
    fun getNote(id: Int): LiveData<NoteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: NoteEntity)

    @Update
    fun update(note: NoteEntity)

    @Delete
    fun delete(note: NoteEntity)

    @Query("DELETE FROM notes")
    fun deleteAll()
}