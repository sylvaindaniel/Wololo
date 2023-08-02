package com.example.mod10recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mod10recyclerview.databinding.TemplateFilmsBinding

data class FilmAdapter(val arrayListFilms : ArrayList<Film>) : RecyclerView.Adapter<FilmAdapter.FilmVH>() {
class FilmVH (val binding : TemplateFilmsBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmVH {
        val binding = TemplateFilmsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        )
        return FilmVH(binding)
    }

    override fun getItemCount(): Int = arrayListFilms.size

    override fun onBindViewHolder(holder: FilmVH, position: Int) {
        holder.binding.film = arrayListFilms[position]
    }
}
