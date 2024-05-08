package com.centaury.simpletaskmanagement.di.module

import android.content.Context
import androidx.room.Room
import com.centaury.simpletaskmanagement.data.db.AppDatabase
import com.centaury.simpletaskmanagement.data.db.AppDatabase.Companion.DATABASE_NAME
import com.centaury.simpletaskmanagement.data.db.NoteDao
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory

class DatabaseModule {
    fun provideAppDatabase(context: Context): AppDatabase {
        val builder = Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
        val factory = SupportFactory(SQLiteDatabase.getBytes("notes_management".toCharArray()))
        builder.openHelperFactory(factory)

        return builder.build()
    }

    fun provideMovieDao(appDatabase: AppDatabase): NoteDao =
        appDatabase.noteDao()
}