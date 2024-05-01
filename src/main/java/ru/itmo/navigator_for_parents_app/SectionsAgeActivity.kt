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
        var selectedAge=intent.getStringExtra("selectedAge")
        binding = ActivitySectionsAgeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val selectedAgeTV = findViewById<TextView>(R.id.selected_age_sections)
        if (selectedAge == null){
            selectedAge = intent.getStringExtra("age")
            selectedAgeTV.text = "$selectedAge лет"
        }
        else{
            selectedAgeTV.text = "$selectedAge лет"
        }
        val backButton = findViewById<ImageButton>(R.id.back_button_section)
        val importantBut = findViewById<TextView>(R.id.important)
        val ageBut = findViewById<TextView>(R.id.age_articles)
        val crisisBut = findViewById<TextView>(R.id.crisis_articles)

        val importantAgeBut = findViewById<TextView>(R.id.importantAge)
        val childRoomBut = findViewById<TextView>(R.id.childRoom)
        val gamesBut = findViewById<TextView>(R.id.games)
        val oftenQuestionsBut = findViewById<TextView>(R.id.oftenQuestions)

        backButton.setOnClickListener {
            val intent = Intent(this, ChooseAgeActivity::class.java)
            startActivity(intent)
            finish()
        }

        importantBut.setOnClickListener {
            val intent = Intent(this, ListArticleActivity::class.java)
            intent.putExtra("name","important")
            intent.putExtra("age",selectedAge)
            startActivity(intent)
            finish()
        }

        crisisBut.setOnClickListener {
            val intent = Intent(this, ListArticleActivity::class.java)
            intent.putExtra("name","crisis")
            intent.putExtra("age",selectedAge)
            startActivity(intent)
            finish()
        }

        ageBut.setOnClickListener {
            val intent = Intent(this, ListArticleActivity::class.java)
            intent.putExtra("name","age")
            intent.putExtra("age",selectedAge)
            startActivity(intent)
            finish()
        }

        importantAgeBut.setOnClickListener {
            val intent = Intent(this, ListArticleActivity::class.java)
            intent.putExtra("name","importantAge")
            intent.putExtra("age",selectedAge)
            startActivity(intent)
            finish()
        }

        childRoomBut.setOnClickListener {
            val intent = Intent(this, ListArticleActivity::class.java)
            intent.putExtra("name","childRoom")
            intent.putExtra("age",selectedAge)
            startActivity(intent)
            finish()
        }

        gamesBut.setOnClickListener {
            val intent = Intent(this, ListArticleActivity::class.java)
            intent.putExtra("name","games")
            intent.putExtra("age",selectedAge)
            startActivity(intent)
            finish()
        }

        oftenQuestionsBut.setOnClickListener {
            val intent = Intent(this, ListArticleActivity::class.java)
            intent.putExtra("name","oftenQuestions")
            intent.putExtra("age",selectedAge)
            startActivity(intent)
            finish()
        }
    }
}