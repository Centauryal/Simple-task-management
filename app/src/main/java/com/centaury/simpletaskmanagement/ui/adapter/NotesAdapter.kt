package com.centaury.simpletaskmanagement.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.centaury.simpletaskmanagement.databinding.ItemListNoteBinding
import com.centaury.simpletaskmanagement.domain.model.NotesModel
import com.centaury.simpletaskmanagement.utils.formatDate

class NotesAdapter(
    private val listNotes: List<NotesModel>,
    private val callback: NotesCallback,
) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder =
        NotesViewHolder.inflate(parent)

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) =
        holder.bind(listNotes[position], callback)

    override fun getItemCount(): Int = listNotes.size

    class NotesViewHolder(binding: ItemListNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        private val notes = binding.txtNote
        private val status = binding.txtStatus
        private val date = binding.txtDate

        companion object {
            fun inflate(parent: ViewGroup): NotesViewHolder {
                return NotesViewHolder(
                    ItemListNoteBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false,
                    ),
                )
            }
        }

        fun bind(
            notesModel: NotesModel,
            callback: NotesCallback,
        ) {
            notes.text = notesModel.title
            status.text = notesModel.status
            date.text = notesModel.date.formatDate()

            itemView.setOnClickListener {
                callback.onItemClicked(notesModel)
            }
        }
    }
}