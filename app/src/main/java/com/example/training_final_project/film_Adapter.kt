package com.example.training_final_project
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class film_Adapter(private val films_list:List<Film>): RecyclerView.Adapter<film_item_holder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): film_item_holder
    {

        val item_film_view=LayoutInflater.from(parent.context).inflate(R.layout.film_item,parent,false)
        return film_item_holder(item_film_view)

    }

    override fun onBindViewHolder(holder: film_item_holder, position: Int) {
        val current_film=films_list[position]
        holder.bind(current_film)

    }

    override fun getItemCount(): Int
    {
        return films_list.size
    }
}