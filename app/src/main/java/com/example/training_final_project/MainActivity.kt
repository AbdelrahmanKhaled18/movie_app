package com.example.training_final_project
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.main_recycler_view)
        val retrofit=Retrofit.Builder().baseUrl("https://developers.themoviedb.org/3/").addConverterFactory(GsonConverterFactory.create())
            .build()
        val filmServices=retrofit.create(film_service::class.java)
        filmServices.get_films().enqueue(object :Callback<List<Film>>{
            override fun onResponse(call: Call<List<Film>>, response: Response<List<Film>>) {

            }

            override fun onFailure(call: Call<List<Film>>, t: Throwable) {

            }
        })

        val list_of_films = get_list_of_films()
        val filmAdapter = film_Adapter(list_of_films)
        recyclerView.adapter=filmAdapter
        filmAdapter.onItemClick={
            val intent=Intent(this,Film_details::class.java)
            intent.putExtra("Film",it)
            startActivity(intent)
        }
    }
    private fun get_list_of_films():List<Film>{
        val films = mutableListOf<Film>()
        films.add(Film("Top Gun:Maverick",R.drawable.download,"Action and Adventure",8.1,"Tom cruise,boudy and anoo and ziad ","old pilot on an new job"))
        films.add(Film("Jurrassic world",R.drawable.jurrassic_world,"science fiction and action",7.9,"chris prat","Four years after the destruction of Isla Nublar, Biosyn operatives attempt to track down Maisie Lockwood, while Dr Ellie Sattler investigates a genetically engineered swarm of giant insects."))
        films.add(Film("Minions",R.drawable.minions,"Comedy,adventure",8.7,"steve carell","In the 1970s, young Gru tries to join a group of supervillains called the Vicious 6 after they oust their leader -- the legendary fighter Wild Knuckles. When the interview turns disastrous, Gru and his Minions go on the run with the Vicious 6 hot on their tails."))
        films.add(Film("Nope",R.drawable.nope,"Horror",7.5,"keke palmer","Nope is a 2022 American neo-Western science fiction horror film directed, written, and co-produced by Jordan Peele under his Monkeypaw Productions banner. It stars Daniel Kaluuya and Keke Palmer as horse-wrangling siblings attempting to capture evidence of an unidentified flying object."))
        films.add(Film("Taslem Ahaly",R.drawable.taslem_ahaly,"Comedy",6.5,"hesham maged",null))
        films.add(Film("kera w el gen",R.drawable.kira_w_el_gen_landscape,"History",null,null,null))
        return films
    }
}