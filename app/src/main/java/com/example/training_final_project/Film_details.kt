package com.example.training_final_project
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Film_details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_details)
        val film= intent.getParcelableExtra<Film>("Film")
        if(film!=null) {
            val film_image_2: ImageView = findViewById(R.id.film_image_2)
            val film_name_2: TextView = findViewById(R.id.film_name_label_2)
            val film_category_2: TextView = findViewById(R.id.film_category_2)
            val film_rating_2: TextView = findViewById(R.id.film_rating_2)
            val film_star_2: TextView = findViewById(R.id.film_star_2)
            val film_description_2: TextView = findViewById(R.id.film_description_2)

            film_image_2.setImageResource(film.Film_image)
            film_name_2.text = film.Film_name
            film_category_2.text=film.film_category
            film_rating_2.text= film.film_rating.toString()
            film_star_2.text=film.film_star
            film_description_2.text=film.film_description
        }

    }
    }
