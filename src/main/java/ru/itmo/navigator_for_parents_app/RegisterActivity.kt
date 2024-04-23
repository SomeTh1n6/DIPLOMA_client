package ru.itmo.navigator_for_parents_app

import android.annotation.SuppressLint
import android.content.Intent
import android.icu.text.IDNA.Info
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import ru.itmo.navigator_for_parents_app.data_files.InfoReg
import java.util.zip.InflaterOutputStream


class RegisterActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val backButton = findViewById<ImageButton>(R.id.back)
        val skipButton = findViewById<Button>(R.id.skip)
        val log_inButton = findViewById<Button>(R.id.log_in)
        val registerButton = findViewById<Button>(R.id.register)

        val emailEditText = findViewById<EditText>(R.id.email_registration)
        val loginEditText = findViewById<EditText>(R.id.login_registration)
        val passwordEditText = findViewById<EditText>(R.id.password_registration)
        val passwordRepeatEditText = findViewById<EditText>(R.id.password_repeat_registration)

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) // как гость
            finish()
        }

        skipButton.setOnClickListener {
            val intent = Intent(this, EntryActivity::class.java)
            startActivity(intent) // как гость
            finish()
        }

        log_inButton.setOnClickListener {
            val intent = Intent(this, EntryActivity::class.java)
            startActivity(intent) // окно входа
            finish()
        }

        registerButton.setOnClickListener {
            if (isEmpty(emailEditText) ||
                    isEmpty(loginEditText) ||
                    isEmpty(passwordEditText) ||
                    isEmpty(passwordRepeatEditText)){
                Toast.makeText(this,"Заполните все поля",Toast.LENGTH_SHORT).show();
            }
            else{
                InfoReg.setEmail(emailEditText.text.toString())
                val intent = Intent(this, EntryActivity::class.java)
                startActivity(intent) // окно входа
                finish()
            }

        }
    }

    private fun isEmpty(etText: EditText): Boolean {
        return etText.text.toString().trim { it <= ' ' }.length <= 0
    }

}