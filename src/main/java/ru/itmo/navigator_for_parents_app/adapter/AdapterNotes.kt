package ru.itmo.navigator_for_parents_app.adapter


import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.itmo.navigator_for_parents_app.R
import ru.itmo.navigator_for_parents_app.adapter.data_notes.Notes
import java.util.LinkedList


class AdapterNotes (
    private val notes: MutableList<Notes>
) : RecyclerView.Adapter<AdapterNotes.ViewHolder> (){

    private var myNotes: MutableList<Notes> = notes as MutableList<Notes>

    override fun getItemCount(): Int = notes.size

    private fun getItem(position: Int) : Notes = notes[position]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), position)

    }

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        private val date: TextView = itemView.findViewById(R.id.date)
        private val time: TextView = itemView.findViewById(R.id.time)
        private val spec: TextView = itemView.findViewById(R.id.specialist)
        private val adress: TextView = itemView.findViewById(R.id.adress)
        private val btnCancel: TextView = itemView.findViewById(R.id.cancel_button)

        fun bind (note: Notes, position: Int) {
            date.text = note.date
            time.text = note.time
            spec.text = note.specialist
            adress.text = note.adress

            btnCancel.setOnClickListener{
                deleteItem(position)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun deleteItem(index: Int){
        myNotes.removeAt(index)
        notifyDataSetChanged()
    }

}