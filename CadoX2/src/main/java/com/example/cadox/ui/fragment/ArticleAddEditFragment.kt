package com.example.cadox.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.cadox.R
import com.example.cadox.bo.Article
import com.example.cadox.databinding.FragmentArticleAddEditBinding
import com.example.cadox.repository.ArticleRepository
import com.google.android.material.snackbar.Snackbar
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ArticleAddEditFragment : Fragment() {
    lateinit var binding: FragmentArticleAddEditBinding
    val args by navArgs<ArticleAddEditFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArticleAddEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.article = args.article
        binding.imageButtonSave.setOnClickListener {
            val articleToUpdate = Article (
                binding.article?.id?:0,
                binding.editTextViewIntitule.text.toString(),
                binding.editTextViewDescription.text.toString(),
                binding.editTextViewPrix.text.toString().toDouble(),
                binding.ratingBar.rating.toInt().toByte(),
                binding.editTextViewUrl.toString(),
                binding.checkBoxAchete.isChecked,
                LocalDate.parse(binding.editTextViewDateAchat.text.toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            )

            ArticleRepository.updateArticle(articleToUpdate)
            findNavController().popBackStack()
        }
    }

}