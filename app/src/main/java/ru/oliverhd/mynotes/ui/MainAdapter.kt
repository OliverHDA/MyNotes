package ru.oliverhd.mynotes.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.oliverhd.mynotes.R
import ru.oliverhd.mynotes.databinding.ItemNoteBinding
import ru.oliverhd.mynotes.model.Note

class MainAdapter : RecyclerView.Adapter<NoteViewHolder>() {

    var notes: List<Note> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int): Unit {
        holder.bind(notes[position])
    }
}

class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var ui: ItemNoteBinding = ItemNoteBinding.bind(itemView)

    fun bind(note: Note) {
        ui.title.text = note.title
        ui.body.text = note.note
        itemView.setBackgroundColor(note.color)
    }
}