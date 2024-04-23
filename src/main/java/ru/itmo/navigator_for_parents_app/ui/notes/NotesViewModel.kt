package ru.itmo.navigator_for_parents_app.ui.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This ifsdgrfdbfgbfgbfg"
    }
    val text: LiveData<String> = _text
}