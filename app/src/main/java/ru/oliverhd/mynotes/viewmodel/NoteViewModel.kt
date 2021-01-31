package ru.oliverhd.mynotes.viewmodel

import androidx.lifecycle.ViewModel
import ru.oliverhd.mynotes.model.Note
import ru.oliverhd.mynotes.model.Repository

class NoteViewModel(private val repository: Repository = Repository) : ViewModel() {

    private var pendingNote: Note? = null
    fun saveChanges(note: Note) {
        pendingNote = note
    }

    override fun onCleared() {
        if (pendingNote != null) {
            repository.saveNote(pendingNote!!)
        }
    }
}