package ru.itmo.navigator_for_parents_app.ui.articles


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.itmo.navigator_for_parents_app.ChooseAgeActivity
import ru.itmo.navigator_for_parents_app.databinding.FragmentArticleBinding


class ArticlesFragment : Fragment() {

    private var _binding: FragmentArticleBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var chooseAgeButton : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val articleViewModel =
            ViewModelProvider(this).get(ArticlesViewModel::class.java)

        _binding = FragmentArticleBinding.inflate(inflater, container, false)
        val root: View = binding.root

        chooseAgeButton = binding.chooseAgeNext

        chooseAgeButton.setOnClickListener{
            val intent = Intent(activity, ChooseAgeActivity::class.java)
            startActivity(intent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}