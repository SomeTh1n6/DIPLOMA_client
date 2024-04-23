package ru.itmo.navigator_for_parents_app.ui.note


import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import ru.itmo.navigator_for_parents_app.R
import ru.itmo.navigator_for_parents_app.adapter.data_notes.DataNotes
import ru.itmo.navigator_for_parents_app.data_files.InfoReg
import ru.itmo.navigator_for_parents_app.data_files.Role
import ru.itmo.navigator_for_parents_app.databinding.FragmentNoteBinding


class NoteFragment : Fragment() {

    private var _binding: FragmentNoteBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNoteBinding.inflate(inflater, container, false)
        val root: View = binding.root


    //1 спииннер
        val spinnerCity: Spinner = binding.chooseCitySpinner
        ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.cities,
            R.layout.dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerCity.adapter = adapter
        }
        spinnerCity.setSelection(0);

        var spinnerSpec : Spinner? = null
        spinnerCity.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                spinnerSpec = secondSpinner(spinnerCity)
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }


    //2 спииннер



    //3 спииннер
        val spinnerDate: Spinner = binding.chooseDateSpinner
        ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.date,
            R.layout.dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerDate.adapter = adapter
        }
        spinnerDate.setSelection(0);


    //4 спииннер
        val spinnerTime: Spinner = binding.chooseTimeSpinner
        ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.time,
            R.layout.dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerTime.adapter = adapter
        }
        spinnerTime.setSelection(0);


        val nextButton: Button = binding.nextButton

        nextButton.setOnClickListener{


            val dialog = Dialog(requireContext())
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setContentView(R.layout.dialog_note)
            val info: TextView = dialog.findViewById(R.id.dialog_info)

            if (InfoReg.getRole() == Role.GUEST){
                info.text = "Сначала надо зарегистрироваться!" //ошибка
                //info.setTextColor(Color.RED);
            }
            else if ((spinnerCity.selectedItem.toString() == "Выберите город") ||
                (spinnerSpec?.selectedItem.toString() == "Выберите специалиста") ||
                (spinnerTime.selectedItem.toString() == "Выберите дату") ||
                (spinnerDate.selectedItem.toString() == "Выберите время")
            ){
                info.text = "Выберите все поля!"
            }
            else{
                addNote(
                    spinnerCity.selectedItem.toString(),
                    spinnerSpec?.selectedItem.toString() ,//spinnerSpecialization.selectedItem.toString()
                    spinnerDate.selectedItem.toString(),
                    spinnerTime.selectedItem.toString()
                )
            }

            val dialogButton: Button = dialog.findViewById<Button>(R.id.ok_button)
            dialogButton.setOnClickListener {
               dialog.dismiss()
            }

            dialog.show()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun addNote(city: String, spec: String, date: String, time: String){
        DataNotes.addNewNote(city, spec, date, time)
    }


    //2 спиннер
    private fun secondSpinner(spinnerCity: Spinner) : Spinner{
        val spinnerSpecialization: Spinner = binding.chooseSpecializationSpinner

        if (spinnerCity.selectedItem.toString() == "Ульяновск"){
            ArrayAdapter.createFromResource(
                requireActivity(),
                R.array.specialist_ULV,
                R.layout.dropdown_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerSpecialization.adapter = adapter
            }

            spinnerSpecialization.setSelection(0);
        }
        else if (spinnerCity.selectedItem.toString() == "Иркутск"){
            ArrayAdapter.createFromResource(
                requireActivity(),
                R.array.specialist_IRK,
                R.layout.dropdown_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerSpecialization.adapter = adapter
            }

            spinnerSpecialization.setSelection(0);
        }
        else {
            ArrayAdapter.createFromResource(
                requireActivity(),
                R.array.specialist_NO,
                R.layout.dropdown_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerSpecialization.adapter = adapter
            }
            spinnerSpecialization.setSelection(0);
        }
        return spinnerSpecialization
    }
}