package com.centaury.simpletaskmanagement.di

import com.centaury.simpletaskmanagement.data.SimpleTaskEntityRepository
import com.centaury.simpletaskmanagement.data.db.NotesEntityData
import com.centaury.simpletaskmanagement.data.db.NotesRepository
import com.centaury.simpletaskmanagement.data.mapper.NotesResultMapper
import com.centaury.simpletaskmanagement.di.module.DatabaseModule
import com.centaury.simpletaskmanagement.domain.SimpleTaskRepository
import org.koin.dsl.module

val appModule =
    module {
        single { DatabaseModule().provideAppDatabase(get()) }
        single { DatabaseModule().provideMovieDao(get()) }

        single<NotesEntityData> { NotesRepository(get()) }
        single<SimpleTaskRepository> { SimpleTaskEntityRepository(get(), get()) }

        single { NotesResultMapper() }
    }