package com.centaury.simpletaskmanagement.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.LinearLayoutManager
import com.centaury.simpletaskmanagement.R
import com.centaury.simpletaskmanagement.databinding.ActivityMainBinding
import com.centaury.simpletaskmanagement.databinding.LayoutMainBinding
import com.centaury.simpletaskmanagement.domain.model.NotesModel
import com.centaury.simpletaskmanagement.ui.adapter.NotesAdapter
import com.centaury.simpletaskmanagement.ui.adapter.NotesCallback
import com.centaury.simpletaskmanagement.utils.Utils
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.Date

class MainActivity : AppCompatActivity(), NotesCallback {
    private val viewModel: MainViewModel by viewModel()

    private lateinit var binding: ActivityMainBinding
    private var materialAlertDialogBuilder: MaterialAlertDialogBuilder? = null
    private var alertDialog: AlertDialog? = null
    private lateinit var txtNoteDialog: TextView
    private lateinit var inputNoteDialog: EditText

    private var listNotes = arrayListOf<NotesModel>()

    private val notesAdapter: NotesAdapter by lazy {
        NotesAdapter(listNotes, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this, R.layout.activity_main)

        initObserver(binding.layoutMain)
        initView(binding.layoutMain)
        initClick(binding)
    }

    private fun initView(layoutMain: LayoutMainBinding) {
        materialAlertDialogBuilder = MaterialAlertDialogBuilder(this)
        with(layoutMain.rvNotes) {
            hasFixedSize()
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = notesAdapter
            addItemDecoration(Utils.TopItemDecoration(55))
        }
    }

    private fun initObserver(layoutMain: LayoutMainBinding) {
        viewModel.getAllNotes.observe(this) { note ->
            val response = note as List<NotesModel>

            Utils.toggleEmptyState(
                note.size,
                layoutMain.txtEmptyNotes,
                layoutMain.rvNotes,
            )
            if (note.isNotEmpty()) {
                listNotes.clear()
                listNotes.addAll(response)
                notesAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun initClick(binding: ActivityMainBinding) {
        binding.fab.setOnClickListener {
            val noteInsert = NotesModel(
                id = 1,
                title = "Testing",
                status = "To Do",
                date = Date(),
            )
            dialogAddNote(false, noteInsert)
        }
    }

    private fun dialogAddNote(isUpdate: Boolean, note: NotesModel) {
        if (alertDialog?.isShowing == false || alertDialog == null) {
            val layoutInflater = LayoutInflater.from(this)
            val view = layoutInflater.inflate(R.layout.dialog_add_note, null)

            val btnPositive =
                if (isUpdate) getString(R.string.btn_update) else getString(R.string.btn_save)

            materialAlertDialogBuilder?.apply {
                setCancelable(false)
                setPositiveButton(btnPositive) { dialog, _ ->
                    dialog.dismiss()
                    viewModel.setInsertNote(note)
                }
                setNegativeButton(getString(R.string.btn_cancel)) { dialog, _ ->
                    dialog.dismiss()
                }
            }

            alertDialog = materialAlertDialogBuilder?.create()
            alertDialog?.setView(view)

            txtNoteDialog = view.findViewById(R.id.txt_dialog_title)
            inputNoteDialog = view.findViewById(R.id.ed_dialog_note)

            alertDialog?.show()
        }

        txtNoteDialog.text =
            if (isUpdate) getString(R.string.txt_update_note) else getString(R.string.txt_add_note)

        if (isUpdate) {
            txtNoteDialog.append(note.title)
        }
    }

    override fun onItemClicked(notesModel: NotesModel) {
        TODO("Not yet implemented")
    }
}