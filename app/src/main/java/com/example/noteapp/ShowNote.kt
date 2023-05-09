package com.example.noteapp

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.noteapp.databinding.ShowNoteBinding

//The note variable will store the Note object being displayed,
//The com.example.noteapp.ShowNote class will
//then use this information to display the note to the user.

class ShowNote(private val note: Note, private val index: Int) : DialogFragment() {
    private var _binding: ShowNoteBinding? = null
    private val binding get() = _binding!!
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val callingActivity = activity as MainActivity
        val inflater = callingActivity.layoutInflater
        _binding = ShowNoteBinding.inflate(inflater)

        //the AlertDialog class is built and used to load the show_note.xml layout file as a dialog window.
        val builder = AlertDialog.Builder(callingActivity)
            .setView(binding.root)
        binding.txtTitle.text = note.title
        binding.txtContents.text = note.contents
        binding.btnOK.setOnClickListener{
            dismiss()
        }

        //the Delete button will run a method from the MainActivity class called deleteNote.
        binding.btnDelete.setOnClickListener{
            callingActivity.deleteNote(index)
            Toast.makeText(callingActivity, resources.getString(R.string.note_deleted),
                Toast.LENGTH_SHORT).show()
            dismiss()
        }
        return builder.create()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}