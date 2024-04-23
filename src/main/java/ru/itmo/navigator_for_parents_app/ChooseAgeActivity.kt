package ru.itmo.navigator_for_parents_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import ru.itmo.navigator_for_parents_app.ui.articles.ArticlesFragment


class ChooseAgeActivity : AppCompatActivity() {
    @SuppressLint("ResourceType", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_age)

        val spinner: Spinner = findViewById(R.id.choose_age_spinner)
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.ages,
            R.layout.dropdown_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
        spinner.setSelection(0);

        val nextBut : Button = findViewById(R.id.choose_age_next)

        nextBut.setOnClickListener{
            val intent = Intent(this, SectionsAgeActivity::class.java)
            startActivity(intent) // выход на регистрацию
            finish()
        }

        val backButton : ImageButton = findViewById(R.id.back_choose_age)

        backButton.setOnClickListener{
            val intent = Intent(this, MainPageActivity::class.java)
            startActivity(intent) // выход на регистрацию
            finish()
        }
    }
}