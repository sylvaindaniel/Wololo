package com.example.cadox.ui.fragment

import android.Manifest
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.example.cadox.databinding.FragmentArticleViewBinding
import com.example.cadox.repository.ArticleRepository
import com.google.android.material.snackbar.Snackbar

class ArticleViewFragment : Fragment() {
    lateinit var binding : FragmentArticleViewBinding
    val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()){
            if(it) {
                val dialMai = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("sms:+33685095038")
                    putExtra("sms_body", "Pour me faire un cadeau : "+"${binding.article?.intitule}.\n")
                }
                startActivity(dialMai)

            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArticleViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.article=ArticleRepository.getArticle(0L)

        binding.imageButtonEdit.setOnClickListener {
            val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
            builder.setMessage("Voulez-vous modifier cet article?")
                .setTitle("Edition Article")
                .setPositiveButton("oui"){ _: DialogInterface, _: Int ->
                    binding.article?.let {article ->
                        val destination =
                            ArticleViewFragmentDirections.actionArticleViewFragmentToArticleAddEditFragment(article)
                        findNavController().navigate((destination))
                    }
                }
                .setNegativeButton("Non", null)
            val dialog: AlertDialog = builder.create()
            dialog.show()

        }


        val openUrlIntent = Intent(Intent.ACTION_VIEW, Uri.parse(binding.article?.url))

        binding.imageButtonUrl.setOnClickListener{
            startActivity(openUrlIntent)
            //Toast.makeText(requireContext(), binding.article?.url ?: "Pas d'URL", Toast.LENGTH_SHORT).show()
        }



        binding.imageButtonSend.setOnClickListener {
            requestPermissionLauncher.launch(Manifest.permission.SEND_SMS)
        }
    }

}