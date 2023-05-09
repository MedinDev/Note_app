package com.example.noteapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.Writer

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NoteAdapter


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        adapter.noteList = retrieveNotes()
        adapter.notifyItemRangeInserted(0, adapter.noteList.size)

//we’ll now set up the com.example.noteapp.NoteAdapter adapter and RecyclerView widget
        adapter = NoteAdapter(this)
        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
        binding.recyclerView.adapter = adapter
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.fab.setOnClickListener {
            NewNote().show(supportFragmentManager, "")
        }
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
    }

    //This onStart method refers to a stage of the activity lifecycle that runs when the activity is displayed to the user,
    //such as when the user returns from the SettingsActivity activity.

    override fun onStart() {
        super.onStart()
        val nightThemeSelected = sharedPreferences.getBoolean("theme", false)
        if (nightThemeSelected) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        val showDividingLines = sharedPreferences.getBoolean("dividingLines", false)
        if (showDividingLines) binding.recyclerView.addItemDecoration(
            DividerItemDecoration(this,
            LinearLayoutManager.VERTICAL)
        )
        else if (binding.recyclerView.itemDecorationCount > 0) binding.recyclerView.removeItemDecorationAt(0)
    }
    companion object {
        private const val FILEPATH = "notes.json"
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


     fun createNewNote(n: Note) {
            adapter.noteList.add(n)
            adapter.notifyItemInserted(adapter.noteList.size - 1)
            saveNotes()
        }

        fun deleteNote(index: Int) {
            adapter.noteList.removeAt(index)
            adapter.notifyItemRemoved(index)
        }

        fun showNote(index: Int) {
            val dialog = ShowNote(adapter.noteList[index], index)
            dialog.show(supportFragmentManager, "")
        }

     private fun saveNotes() {
            val notes = adapter.noteList
            val gson = GsonBuilder().create()
            val jsonNotes = gson.toJson(notes)
            var writer: Writer? = null
            try {
                val out = this.openFileOutput(FILEPATH, Context.MODE_PRIVATE)
                writer = OutputStreamWriter(out)
                writer.write(jsonNotes)
            } catch (e: Exception) {
                writer?.close()
            } finally {
                writer?.close()
            }
        }

     private fun retrieveNotes(): MutableList<Note> {
            var noteList = mutableListOf<Note>()
            if (this.getFileStreamPath(FILEPATH).isFile) {
                var reader: BufferedReader? = null
                try {
                    val fileInput = this.openFileInput(FILEPATH)
                    reader = BufferedReader(InputStreamReader(fileInput))
                    val stringBuilder = StringBuilder()
                    for (line in reader.readLine()) stringBuilder.append(line)
                    if (stringBuilder.isNotEmpty()){
                        val listType = object : TypeToken<List<Note>>() {}.type
                        noteList = Gson().fromJson(stringBuilder.toString(), listType)
                    }
                } catch (e: Exception) {
                    reader?.close()
                } finally {
                    reader?.close()
                }
            }
        return noteList
     }

}