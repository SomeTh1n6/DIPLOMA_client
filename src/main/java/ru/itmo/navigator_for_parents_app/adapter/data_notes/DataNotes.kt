package ru.itmo.navigator_for_parents_app.adapter.data_notes


object DataNotes {

    private val notesList: MutableList<Notes> = mutableListOf()

    fun getNotesList(): MutableList<Notes> {
        return notesList
    }

    fun addNewNote(city: String, spec: String, date: String, time: String){
        val note = Notes(date, time, spec, city)
        notesList.add(note)
    }
}


