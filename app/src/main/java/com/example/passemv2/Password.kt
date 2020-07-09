package com.example.passemv2

import androidx.room.ColumnInfo //Especifica o nome da coluna
import androidx.room.Entity //Representa uma tabela SQLite
import androidx.room.PrimaryKey //chave primária


@Entity(tableName = "word_passe")
class Word(@PrimaryKey @ColumnInfo(name = "passe") val word: String)