package com.example.passemv2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData //serve para armazenar em cache a lista de palavras
import androidx.lifecycle.viewModelScope
import com.example.passemv2.Passe.WordRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PassViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WordRepository
    val allWords: LiveData<List<Word>>

    init {
        val wordsDao = WordRoomDatabase.getDatabase(application).wordDao()
        repository = WordRepository(wordsDao)
        allWords = repository.allWords
    }

    fun insert(word: Word) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(word)
    }
}