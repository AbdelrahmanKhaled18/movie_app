package com.example.training_final_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.main_recycler_view)
        val list_of_films = get_list_of_films()
        val filmAdapter = film_Adapter(list_of_films)
        recyclerView.adapter=filmAdapter

    }
    private fun get_list_of_films():List<Film>{
        val films = mutableListOf<Film>()
        films.add(Film("Top Gun:Maverick",R.drawable.download,"Action and Adventure"))
        films.add(Film("Jurrassic world",R.drawable.jurrassic_world,"science fiction and action"))
        films.add(Film("Minions",R.drawable.minions,"Comedy,adventure"))
        films.add(Film("Nope",R.drawable.nope,"Horror"))
        films.add(Film("Taslem Ahaly",R.drawable.taslem_ahaly,"Comedy"))
        films.add(Film("kera w el gen",R.drawable.kira_w_el_gen_landscape,"History"))
        return films



    }
}