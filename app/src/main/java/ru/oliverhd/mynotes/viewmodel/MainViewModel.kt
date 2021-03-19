package ru.oliverhd.mynotes.viewmodel

import androidx.lifecycle.Observer
import ru.oliverhd.mynotes.model.Note
import ru.oliverhd.mynotes.model.NoteResult
import ru.oliverhd.mynotes.model.NoteResult.Error
import ru.oliverhd.mynotes.model.Repository
import ru.oliverhd.mynotes.ui.MainViewState
import ru.oliverhd.mynotes.ui.base.BaseViewModel

class MainViewModel(val repository: Repository = Repository) :
    BaseViewModel<List<Note>?, MainViewState>() {

    private val notesObserver = object : Observer<NoteResult> {
        override fun onChanged(t: NoteResult?) {
            if (t == null) return

            when (t) {
                is NoteResult.Success<*> -> {
                    viewStateLiveData.value = MainViewState(notes = t.data as? List<Note>)
                }
                is Error -> {
                    viewStateLiveData.value = MainViewState(error = t.error)
                }
            }
        }
    }

    private val repositoryNotes = repository.getNotes()

    init {
        viewStateLiveData.value = MainViewState()
        repositoryNotes.observeForever(notesObserver)
    }

    override fun onCleared() {
        repositoryNotes.removeObserver(notesObserver)
    }
}