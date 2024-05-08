package com.centaury.simpletaskmanagement.di

import com.centaury.simpletaskmanagement.data.SimpleTaskEntityRepository
import com.centaury.simpletaskmanagement.data.db.NotesEntityData
import com.centaury.simpletaskmanagement.data.db.NotesRepository
import com.centaury.simpletaskmanagement.data.mapper.NotesResultMapper
import com.centaury.simpletaskmanagement.di.module.DatabaseModule
import com.centaury.simpletaskmanagement.domain.SimpleTaskRepository
import com.centaury.simpletaskmanagement.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule =
    module {
        viewModel { MainViewModel(get()) }

        single { DatabaseModule().provideAppDatabase(get()) }
        single { DatabaseModule().provideMovieDao(get()) }

        factory<SimpleTaskRepository> { SimpleTaskEntityRepository(get(), get()) }
        factory<NotesEntityData> { NotesRepository(get()) }

        single { SimpleTaskEntityRepository(get(), get()) }
        single { NotesRepository(get()) }
        single { NotesResultMapper() }
    }