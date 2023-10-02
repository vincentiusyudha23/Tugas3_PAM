package com.example.pam

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SkillViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply{
        value = "Kotlin"
    }

    val text: LiveData<String> = _text
}