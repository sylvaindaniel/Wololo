package com.example.mod5demonavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.Navigation
import com.example.mod5demonavigation.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    lateinit var binding : FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Récupère le binding
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        //récupère le constraint layout (le viewgroup le plus haut) généralement le ConstraintLayout ou FrameLayout
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            //on créé la direction pour naviguer de LoginFragment vers HomeFragment
            val direction = LoginFragmentDirections.actionLoginFragmentToHomeFragment(
                User(
                    binding.editTextTextEmailAddress.text.toString(),
                    binding.editTextTextPassword2.text.toString()
                )
            )
            Navigation.findNavController(view).navigate(direction)
        }
    }

}