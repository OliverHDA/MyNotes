package ru.oliverhd.mynotes.ui

import ru.oliverhd.mynotes.model.Note
import ru.oliverhd.mynotes.ui.base.BaseViewState

class MainViewState(notes: List<Note>? = null, error: Throwable? = null)
    : BaseViewState<List<Note>?>(notes, error)