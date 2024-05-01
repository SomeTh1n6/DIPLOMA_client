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
import ru.itmo.navigator_for_parents_app.adapter.data.Articles

class ListArticleActivity : AppCompatActivity() {

    private var adapter: AdapterArticles? = null
    private var articles: List<Articles>? = null
    private var ages: List<Articles>? = null
    private var crisis: List<Articles>? = null

    private var importantAge: List<Articles>? = null
    private var childRoom: List<Articles>? = null
    private var oftenQuestions: List<Articles>? = null
    private var games: List<Articles>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_article)

        val name=intent.getStringExtra("name")
        val age=intent.getStringExtra("age")
        val header: TextView = findViewById(R.id.name_group_article)
        val ageTV: TextView = findViewById(R.id.age_articles)

        ageTV.text = "$age лет"

        when (age){
            "0-3" -> {
                articles = DataStorage.getArticleImportantList()
                ages = DataStorage.getArticleAgeList()
                crisis = DataStorage.getArticleCrisisList()

                importantAge = DataStorage.getArticleImportantAgeList()
                childRoom = DataStorage.getArticleChildRoomList()
                oftenQuestions = DataStorage.getArticleOftenQuestionsList()
                games = DataStorage.getArticleGamesList()
            }
            "4-7" -> {
                articles = DataStorage.getArticleImportantList1()
                ages = DataStorage.getArticleAgeList1()
                crisis = DataStorage.getArticleCrisisList1()

                importantAge = DataStorage.getArticleImportantAgeList1()
                childRoom = DataStorage.getArticleChildRoomList1()
                oftenQuestions = DataStorage.getArticleOftenQuestionsList1()
                games = DataStorage.getArticleGamesList1()
            }
            "8-12" -> {
                articles = DataStorage.getArticleImportantList2()
                ages = DataStorage.getArticleAgeList2()
                crisis = DataStorage.getArticleCrisisList2()

                importantAge = DataStorage.getArticleImportantAgeList2()
                childRoom = DataStorage.getArticleChildRoomList2()
                oftenQuestions = DataStorage.getArticleOftenQuestionsList2()
                games = DataStorage.getArticleGamesList2()
            }
            "13-17" -> {
                articles = DataStorage.getArticleImportantList3()
                ages = DataStorage.getArticleAgeList3()
                crisis = DataStorage.getArticleCrisisList3()

                importantAge = DataStorage.getArticleImportantAgeList3()
                childRoom = DataStorage.getArticleChildRoomList3()
                oftenQuestions = DataStorage.getArticleOftenQuestionsList3()
                games = DataStorage.getArticleGamesList3()
            }
        }


        if (name == "important"){
            adapter = AdapterArticles(this, articles!!, age!!)
            header.text = "Важно"
        }
        else if(name == "age"){
            adapter = AdapterArticles(this, ages!!, age!!)
            header.text = "Возрастные особенности"
        }
        else if(name == "crisis"){
            adapter = AdapterArticles(this, crisis!!, age!!)
            header.text = "Кризисы"
        }
        else if(name == "importantAge"){
            adapter = AdapterArticles(this, importantAge!!, age!!)
            header.text = "Важно в этом возрасте"
        }
        else if(name == "childRoom"){
            adapter = AdapterArticles(this, childRoom!!, age!!)
            header.text = "Детская комната"
        }
        else if(name == "oftenQuestions"){
            adapter = AdapterArticles(this, oftenQuestions!!, age!!)
            header.text = "Частые вопросы"
        }
        else if(name == "games"){
            adapter = AdapterArticles(this, games!!, age!!)
            header.text = "Игры и занятия"
        }

        val list = findViewById<RecyclerView>(R.id.articleList)
        list.adapter = adapter

        val decoration = DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)
        list.addItemDecoration(decoration)

        val backButton : ImageButton = findViewById(R.id.back_choose_category)

        backButton.setOnClickListener{
            val intent = Intent(this, SectionsAgeActivity::class.java)
            intent.putExtra("age", age)
            startActivity(intent) // как гость
            finish()
        }

    }
}