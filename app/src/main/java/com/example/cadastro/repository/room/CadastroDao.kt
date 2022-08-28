package com.example.cadastro.repository.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import com.example.cadastro.model.Cadastro
import androidx.room.*
import com.example.cadastro.sqlite.COLUMN_EMAIL
import com.example.cadastro.sqlite.COLUMN_NAME
import com.example.cadastro.sqlite.TABLE_CADASTRO

@Dao
interface CadastroDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(cadastro: Cadastro): Long

    @Update
    fun update(){}

    @Delete
    fun remove(){}

    @Query("SELECT * FROM $TABLE_CADASTRO WHERE $COLUMN_NAME LIKE :query ORDER BY $COLUMN_NAME")
    fun search(query: String): LiveData<List<Cadastro>>

    @Query("SELECT * FROM $TABLE_CADASTRO WHERE $COLUMN_EMAIL = :email")
    fun cadastroByEmail(email: String): LiveData<Cadastro>
}