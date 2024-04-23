package ru.itmo.navigator_for_parents_app.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import ru.itmo.navigator_for_parents_app.data_files.InfoReg
import ru.itmo.navigator_for_parents_app.data_files.Role
import ru.itmo.navigator_for_parents_app.databinding.FragmentAccountBinding

class AccountFragment : Fragment() {

    private var _binding: FragmentAccountBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var editTextName : EditText
    private lateinit var editTextCity : EditText
    private lateinit var editTextNumber : EditText
    private lateinit var editTextMail : EditText
    private lateinit var chageButton : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        val root: View = binding.root

        chageButton = binding.changeButton
        editTextName = binding.enterNameText
        editTextCity = binding.enterCityText
        editTextNumber = binding.enterNumberText
        editTextMail = binding.enterMailText

        editTextName.isEnabled = false
        editTextCity.isEnabled = false
        editTextNumber.isEnabled = false
        editTextMail.isEnabled = false

        if (InfoReg.getRole() == Role.GUEST){
            editTextMail.setText("-")
        }
        else{
            editTextMail.setText(InfoReg.getEmail())
        }


        chageButton.setOnClickListener {
            if (InfoReg.getRole() == Role.GUEST){
                Toast.makeText(activity,"Сначала надо зарегистрироваться",Toast.LENGTH_SHORT).show();
            }
            else{
                if (chageButton.text == "Изменить") {
                    chageButton.text = "Применить"
                    editTextName.isEnabled = true
                    editTextCity.isEnabled = true
                    editTextNumber.isEnabled = true
                    editTextMail.isEnabled = true
                } else {
                    chageButton.text = "Изменить"
                    editTextName.isEnabled = false
                    editTextCity.isEnabled = false
                    editTextNumber.isEnabled = false
                    editTextMail.isEnabled = false
                    Toast.makeText(activity,"Изменения успешно применены",Toast.LENGTH_SHORT).show();
                }
            }

        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}