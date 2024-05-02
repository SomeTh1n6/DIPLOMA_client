package ru.itmo.navigator_for_parents_app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import ru.itmo.navigator_for_parents_app.R
import ru.itmo.navigator_for_parents_app.data.ChatMessage
import java.util.ArrayList

class ChatArrayAdapter(context: Context, textViewResourceId: Int) : ArrayAdapter<ChatMessage>(context, textViewResourceId) {

    private var chatMessageList: MutableList<ChatMessage> = ArrayList()

    fun add(message: ChatMessage) {
        chatMessageList.add(message)
        super.add(message)
    }

    override fun getCount(): Int {
        return chatMessageList.size
    }

    override fun getItem(index: Int): ChatMessage {
        return chatMessageList[index]
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var row = convertView
        val chatMessageObj = getItem(position)
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        row = if (chatMessageObj.left) {
            inflater.inflate(R.layout.right, parent, false)
        } else {
            inflater.inflate(R.layout.left, parent, false)
        }
        val chatText = row.findViewById<TextView>(R.id.msgr)
        chatText.text = chatMessageObj.message
        return row
    }
}