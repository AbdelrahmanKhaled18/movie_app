package com.example.training_final_project
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class film_item_holder(itemView: View) :RecyclerView.ViewHolder(itemView)
{
   private val film_name:TextView
   private val film_image:ImageView
   init
   {
       film_name=itemView.findViewById(R.id.film_name_label)
       film_image=itemView.findViewById(R.id.film_image)
       film_image.setOnClickListener {

       }
   }
    fun bind(film: Film)
    {
        film_name.text = film.Film_name
        film_image.setImageResource(film.Film_image)
    }
}