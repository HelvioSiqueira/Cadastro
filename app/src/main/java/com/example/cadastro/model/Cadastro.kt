package com.example.cadastro.model

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.example.cadastro.repository.room.COLUMN_ID
import com.example.cadastro.repository.room.TABLE_CADASTRO

@Entity(tableName = TABLE_CADASTRO)
data class Cadastro(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    var id: Long = 0,
    var nome: String = "",
    var email: String = "",
    var senha: String = ""
){
    override fun toString(): String = nome
}
