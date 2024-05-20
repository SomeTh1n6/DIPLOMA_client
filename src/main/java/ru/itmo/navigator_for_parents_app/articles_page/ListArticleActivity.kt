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

    private var leading: List<Articles>? = null
    private var ages: List<Articles>? = null
    private var crisis: List<Articles>? = null

    private var important: List<Articles>? = null
    private var physical: List<Articles>? = null
    private var game: List<Articles>? = null
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
                important = DataStorage.getArticleImportantList()
                ages = DataStorage.getArticleAgeList()
                crisis = DataStorage.getArticleCrisisList()
                leading = DataStorage.getArticleLeadingList()
                physical = DataStorage.getArticlePhysicalList()
                game = DataStorage.getArticleGamesList()
            }
            "4-7" -> {
                important = DataStorage.getArticleImportantList1()
                ages = DataStorage.getArticleAgeList1()
                crisis = DataStorage.getArticleCrisisList1()
                leading = DataStorage.getArticleLeadingList1()
                physical = DataStorage.getArticlePhysicalList1()
                game = DataStorage.getArticleGamesList1()
            }
            "8-12" -> {
                important = DataStorage.getArticleImportantList2()
                ages = DataStorage.getArticleAgeList2()
                crisis = DataStorage.getArticleCrisisList2()
                leading = DataStorage.getArticleLeadingList2()
                physical = DataStorage.getArticlePhysicalList2()
                game = DataStorage.getArticleGamesList2()
            }
            "13-17" -> {
                important = DataStorage.getArticleImportantList3()
                ages = DataStorage.getArticleAgeList3()
                crisis = DataStorage.getArticleCrisisList3()
                leading = DataStorage.getArticleLeadingList3()
                physical = DataStorage.getArticlePhysicalList3()
                game = DataStorage.getArticleGamesList3()
            }
        }


        if (name == "important"){
            adapter = AdapterArticles(this, important!!, age!!)
            header.text = "Важно знать"
        }
        else if(name == "age"){
            adapter = AdapterArticles(this, ages!!, age!!)
            header.text = "Возрастные особенности"
        }
        else if(name == "crisis"){
            adapter = AdapterArticles(this, crisis!!, age!!)
            header.text = "Кризисы"
        }
        else if(name == "physical"){
            adapter = AdapterArticles(this, physical!!, age!!)
            header.text = "Физическое развитие"
        }
        else if(name == "game"){
            adapter = AdapterArticles(this, game!!, age!!)
            header.text = "Игры,  игрушки, увлечения"
        }
        else if(name == "leading"){
            adapter = AdapterArticles(this, leading!!, age!!)
            header.text = "Ведущая деятельность"
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