package ru.itmo.navigator_for_parents_app.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.itmo.navigator_for_parents_app.ArticleActivity
import ru.itmo.navigator_for_parents_app.R
import ru.itmo.navigator_for_parents_app.SectionsAgeActivity
import ru.itmo.navigator_for_parents_app.adapter.data.Articles
import ru.itmo.navigator_for_parents_app.adapter.data_notes.Notes
import ru.itmo.navigator_for_parents_app.ui.notes.NotesFragment

class AdapterArticles(
    private val context: Context,
    private val articles: List<Articles>
) : RecyclerView.Adapter<AdapterArticles.ViewHolder> (){

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getItemCount(): Int = articles.size

    private fun getItem(position: Int) : Articles = articles[position]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_article_view, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener{
            context.startActivity(
                Intent(context, ArticleActivity::class.java).putExtra("position",position),
            )
        }
    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        private val title: TextView = itemView.findViewById(R.id.title)
        private val description: TextView = itemView.findViewById(R.id.description)

        fun bind (article: Articles) {
            title.text = article.title
            description.text = article.description
        }
    }

}