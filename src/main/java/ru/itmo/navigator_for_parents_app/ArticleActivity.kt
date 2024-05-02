package ru.itmo.navigator_for_parents_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import ru.itmo.navigator_for_parents_app.articles_page.ListArticleActivity

class ArticleActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        val nameArticle: TextView = findViewById(R.id.name_article)
        val contentTV: TextView = findViewById(R.id.contentArticle)


        val age = intent.getStringExtra("age")
        val name = intent.getStringExtra("name")
        val content = intent.getStringExtra("content")

        nameArticle.text = name
        contentTV.text = content


        val backButton : ImageButton = findViewById(R.id.back_article)

        backButton.setOnClickListener{
            val intent = Intent(this, SectionsAgeActivity::class.java)
            intent.putExtra("age", age)
            startActivity(intent) // как гость
            finish()
        }
    }
}