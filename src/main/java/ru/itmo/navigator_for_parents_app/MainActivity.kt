package ru.itmo.navigator_for_parents_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import ru.itmo.navigator_for_parents_app.data_files.InfoReg
import ru.itmo.navigator_for_parents_app.data_files.Role

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val log_inButton = findViewById<Button>(R.id.log_in)
        val registerButton = findViewById<Button>(R.id.register)
        val guest_Button = findViewById<Button>(R.id.guest)

        log_inButton.setOnClickListener {
            val intent = Intent(this, EntryActivity::class.java)
            startActivity(intent)
            finish()
        }

        registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        guest_Button.setOnClickListener {
            InfoReg.setRole(Role.GUEST)
            val intent = Intent(this, MainPageActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}