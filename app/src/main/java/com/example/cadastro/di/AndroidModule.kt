package com.example.cadastro.di

import com.example.cadastro.cadastrar.CadastrarViewModel
import com.example.cadastro.lista.CadastroListViewModel
import com.example.cadastro.login.LoginViewModel
import com.example.cadastro.model.Cadastro
import com.example.cadastro.repository.CadastroRepository
import com.example.cadastro.repository.room.CadastroDatabase
import com.example.cadastro.repository.room.RoomRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
    single { this }

    single {
        RoomRepository(CadastroDatabase.getDatabase(context = get())) as CadastroRepository
    }

    viewModel{
        CadastrarViewModel(repository = get())
    }

    viewModel{
        LoginViewModel(repository = get())
    }

    viewModel{
        CadastroListViewModel(repository = get())
    }
}