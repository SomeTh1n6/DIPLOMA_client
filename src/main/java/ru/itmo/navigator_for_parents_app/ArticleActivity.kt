package ru.itmo.navigator_for_parents_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import ru.itmo.navigator_for_parents_app.articles_page.ListArticleActivity

class ArticleActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        val age = intent.getStringExtra("age")

        val backButton : ImageButton = findViewById(R.id.back_article)

        backButton.setOnClickListener{
            val intent = Intent(this, SectionsAgeActivity::class.java)
            intent.putExtra("age", age)
            startActivity(intent) // как гость
            finish()
        }
    }
}