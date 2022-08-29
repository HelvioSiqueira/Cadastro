package com.example.cadastro.model

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.example.cadastro.repository.room.*

@Entity(tableName = TABLE_CADASTRO)
data class Cadastro(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    var id: Long = 0,

    @ColumnInfo(name = COLUMN_NAME)
    var nome: String = "",

    @ColumnInfo(name = COLUMN_EMAIL)
    var email: String = "",

    @ColumnInfo(name = COLUMN_SENHA)
    var senha: String = ""
){
    override fun toString(): String = nome
}
