package com.example.cadastro.repository.room

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.cadastro.model.Cadastro
import com.example.cadastro.repository.CadastroRepository

class RoomRepository(database: CadastroDatabase): CadastroRepository {

    private val cadastroDao = database.cadastroDao()

    override fun save(cadastro: Cadastro) {
        if(cadastro.id == 0L){
            val id = cadastroDao.insert(cadastro)
            cadastro.id = id
        } else {
            cadastroDao.update()
        }
    }

    override fun remove(cadastro: Cadastro) {
        TODO("Not yet implemented")
    }

    override fun cadastroByEmail(email: String): Cadastro {
        Log.d("HSV", "String recebida no viewmodel: $email")
        return cadastroDao.cadastroByEmail(email)
    }

    override fun search(term: String): LiveData<List<Cadastro>> {
        return cadastroDao.search(term)
    }
}