package ru.itmo.navigator_for_parents_app.ui.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import ru.itmo.navigator_for_parents_app.adapter.AdapterNotes
import ru.itmo.navigator_for_parents_app.adapter.data_notes.DataNotes
import ru.itmo.navigator_for_parents_app.adapter.data_notes.Notes
import ru.itmo.navigator_for_parents_app.databinding.FragmentOurNotesBinding

class NotesFragment : Fragment() {

    private var _binding: FragmentOurNotesBinding? = null
    private val notes: MutableList<Notes> =
        DataNotes.getNotesList()// массив с данными по записям

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentOurNotesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val list : RecyclerView = binding.notesList
        val adapter = AdapterNotes(notes)
        list.adapter = adapter
        val decoration = DividerItemDecoration(requireActivity(), DividerItemDecoration.HORIZONTAL)
        list.addItemDecoration(decoration)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}