package com.example.cadastro.di

import com.example.cadastro.cadastrar.CadastrarPresenter
import com.example.cadastro.cadastrar.CadastrarView
import com.example.cadastro.lista.CadastroListPresenter
import com.example.cadastro.lista.CadastroListView
import com.example.cadastro.login.LoginPresenter
import com.example.cadastro.login.LoginView
import com.example.cadastro.repository.CadastroRepository
import com.example.cadastro.sqlite.SQLiteRepository
import org.koin.dsl.module

val androidModule = module {
    single { this }

    single {
        SQLiteRepository(ctx = get()) as CadastroRepository
    }

    factory { (view: CadastrarView)->
        CadastrarPresenter(view, repository = get())
    }

    factory { (view: LoginView)->
        LoginPresenter(view, repository = get())
    }

    factory {(view: CadastroListView)->
        CadastroListPresenter(view, repository = get())
    }
}