package com.example.training_final_project
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class film_Adapter(private val films_list:List<Film>): RecyclerView.Adapter<film_Adapter.film_item_holder>()
{
    var onItemClick: ((Film)->Unit)?=null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): film_item_holder
    {
        val item_film_view=LayoutInflater.from(parent.context).inflate(R.layout.film_item,parent,false)
        return film_item_holder(item_film_view)
    }

    override fun onBindViewHolder(holder: film_item_holder, position: Int) {
        val current_film=films_list[position]
        holder.bind(current_film)
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(current_film)

        }
    }

    override fun getItemCount(): Int
    {
        return films_list.size
    }

    inner class film_item_holder(itemView: View) :RecyclerView.ViewHolder(itemView)
    {
        private val film_name: TextView
        private val film_image: ImageView
        init
        {
            film_name=itemView.findViewById(R.id.film_name_label)
            film_image=itemView.findViewById(R.id.film_image)

            itemView.setOnClickListener {
                val current_film =films_list[layoutPosition]
                val intent=Intent(itemView.context,Film_details::class.java)
                intent.putExtra("Film",current_film)
                itemView.context.startActivity(intent)
            }
        }
        fun bind(film: Film)
        {
            film_name.text = film.Film_name
            film_image.setImageResource(film.Film_image)
        }
    }
}