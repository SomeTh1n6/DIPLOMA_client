package ru.itmo.navigator_for_parents_app


import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.widget.AbsListView
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

import ru.itmo.navigator_for_parents_app.adapter.ChatArrayAdapter
import ru.itmo.navigator_for_parents_app.data.ChatMessage
import ru.itmo.navigator_for_parents_app.data.Item

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class ChatActivity : AppCompatActivity() {

    val waitList = arrayListOf("Думаем", "Думаем .", "Думаем ..", "Думаем ...")
    var finishWait = false

    val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS) // Время ожидания соединения
        .readTimeout(30, TimeUnit.SECONDS) // Время ожидания ответа
        .writeTimeout(30, TimeUnit.SECONDS) // Время ожидания записи
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:8000/") // Replace with the actual URL of your FastAPI server
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    private val service = retrofit.create(FastAPIService::class.java)

    private lateinit var button: ImageButton
    private lateinit var button_back: ImageButton
    private lateinit var editText: EditText
    private lateinit var chatListView: ListView

    private var side = false

    private lateinit var chatArrayAdapter: ChatArrayAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        button_back = findViewById(R.id.back)
        button = findViewById(R.id.sendButton)
        editText = findViewById(R.id.messageEditText)
        chatListView = findViewById(R.id.chatListView)

        chatArrayAdapter = ChatArrayAdapter(this, R.layout.right)

        chatListView.transcriptMode = AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL
        chatListView.adapter = chatArrayAdapter

        editText.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                sendChatMessage()
            } else false
        }


        button.setOnClickListener {
            val text = editText.text.toString()
            // sendTextToServer(text, responseText
            sendChatMessage()

        }

        button_back.setOnClickListener {
            val intent = Intent(this, MainPageActivity::class.java)
            startActivity(intent) // выход на регистрацию
            finish()
        }
    }

    private fun sendChatMessage(): Boolean {
        if (editText.text.toString().trim().isNotEmpty()){
            finishWait = false
            side = !side
            chatArrayAdapter.add(ChatMessage(side, editText.text.toString().trim()))
            side = !side

            chatArrayAdapter.add(ChatMessage(side,"Думаем"))
            var index = 0
            CoroutineScope(Dispatchers.Main).launch{
                while (!finishWait){
                    val lastMessageIndex = chatArrayAdapter.count - 1
                    chatArrayAdapter.getItem(lastMessageIndex).let {
                        it.message = waitList.get(index)
                        chatArrayAdapter.notifyDataSetChanged()
                    }
                    delay(500)
                    index = (index+1)% waitList.size

                }
            }

            sendTextToServer(editText.text.toString().trim()) {result ->
                val lastMessageIndex = chatArrayAdapter.count - 1
                finishWait = true
                chatArrayAdapter.getItem(lastMessageIndex).let {
                    it.message = result
                    chatArrayAdapter.notifyDataSetChanged()
                }
            }
            editText.setText("")
            return true
        }
        return false
    }


    private fun sendTextToServer(text: String, callback: (String) -> Unit) {
        val call = service.echo(Item(text))
        call.enqueue(object : Callback<EchoResponse> {

            override fun onResponse(call: Call<EchoResponse>, response: Response<EchoResponse>) {
                if (response.isSuccessful) {
                    val echoResponse = response.body()
                    callback.invoke(echoResponse?.echo ?: "")
                } else {
                    callback.invoke(response.message())
                }
            }

            override fun onFailure(call: Call<EchoResponse>, t: Throwable) {
                callback.invoke("Ошибка получения данных с сервера "  + t.message)
            }
        })
    }
}

