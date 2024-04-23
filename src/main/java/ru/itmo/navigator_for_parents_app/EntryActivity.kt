package ru.itmo.navigator_for_parents_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import ru.itmo.navigator_for_parents_app.data_files.InfoReg
import ru.itmo.navigator_for_parents_app.data_files.Role

class EntryActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)

        val log_inButton = findViewById<Button>(R.id.enter)
        val registerButton = findViewById<Button>(R.id.register)
        val skipButton = findViewById<Button>(R.id.skip)
        val backButton = findViewById<ImageButton>(R.id.back)

        log_inButton.setOnClickListener {
            InfoReg.setRole(Role.USER)
            val intent = Intent(this, MainPageActivity::class.java)
            startActivity(intent) // как зареганный
            finish()
        }

        registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent) // выход на регистрацию
            finish()
        }

        skipButton.setOnClickListener {
            InfoReg.setRole(Role.GUEST)
            val intent = Intent(this, MainPageActivity::class.java)
            startActivity(intent) // как гость
            finish()
        }

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) // как гость
            finish()
        }
    }
}