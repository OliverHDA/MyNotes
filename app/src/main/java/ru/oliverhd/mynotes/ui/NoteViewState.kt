package ru.oliverhd.mynotes.ui

import ru.oliverhd.mynotes.model.Note
import ru.oliverhd.mynotes.ui.base.BaseViewState

class NoteViewState(note: Note? = null, error: Throwable? = null) : BaseViewState<Note?>(note, error)