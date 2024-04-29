package ru.itmo.navigator_for_parents_app

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.itmo.navigator_for_parents_app.articles_page.ListArticleActivity
import ru.itmo.navigator_for_parents_app.databinding.ActivitySectionsAgeBinding


class SectionsAgeActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySectionsAgeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val selectedAge=intent.getStringExtra("selectedAge")
        binding = ActivitySectionsAgeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val selectedAgeTV = findViewById<TextView>(R.id.selected_age_sections)
        selectedAgeTV.text = "$selectedAge лет"
        val backButton = findViewById<ImageButton>(R.id.back_button_section)
        val importantBut = findViewById<TextView>(R.id.important)
        val ageBut = findViewById<TextView>(R.id.age_articles)
        val crisisBut = findViewById<TextView>(R.id.crisis_articles)

        backButton.setOnClickListener {
            val intent = Intent(this, ChooseAgeActivity::class.java)
            startActivity(intent)
            finish()
        }

        importantBut.setOnClickListener {
            val intent = Intent(this, ListArticleActivity::class.java)
            intent.putExtra("name","important")
            startActivity(intent)
            finish()
        }

        crisisBut.setOnClickListener {
            val intent = Intent(this, ListArticleActivity::class.java)
            intent.putExtra("name","crisis",)
            startActivity(intent)
            finish()
        }

        ageBut.setOnClickListener {
            val intent = Intent(this, ListArticleActivity::class.java)
            intent.putExtra("name","age")
            startActivity(intent)
            finish()
        }

    }
}