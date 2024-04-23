package ru.itmo.navigator_for_parents_app.articles_page

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import ru.itmo.navigator_for_parents_app.R
import ru.itmo.navigator_for_parents_app.SectionsAgeActivity
import ru.itmo.navigator_for_parents_app.adapter.data.DataStorage
import ru.itmo.navigator_for_parents_app.adapter.AdapterArticles

class ListArticleActivity : AppCompatActivity() {

    private var adapter: AdapterArticles? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_article)

        val name=intent.getStringExtra("name")
        val header: TextView = findViewById(R.id.name_group_article)

        val articles = DataStorage.getArticleImportantList()
        val ages = DataStorage.getArticleAgeList()
        val crisis = DataStorage.getArticleCrisisList()

        if (name == "important"){
            adapter = AdapterArticles(this, articles)
            header.text = "Важно"
        }
        else if(name == "age"){
            adapter = AdapterArticles(this, ages)
            header.text = "Возрастные особенности"
        }
        else if(name == "crisis"){
            adapter = AdapterArticles(this, crisis)
            header.text = "Кризисы"
        }


        val list = findViewById<RecyclerView>(R.id.articleList)
        list.adapter = adapter

        val decoration = DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)
        list.addItemDecoration(decoration)

        val backButton : ImageButton = findViewById(R.id.back_choose_category)

        backButton.setOnClickListener{
            val intent = Intent(this, SectionsAgeActivity::class.java)
            startActivity(intent) // как гость
            finish()
        }

    }
}