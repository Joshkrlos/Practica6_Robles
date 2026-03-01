package mx.edu.itesca.practica6

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Catalogo : AppCompatActivity() {
    var adapter: PeliculaAdapter? = null
    var seriesAdapter: PeliculaAdapter? = null
    var peliculas = ArrayList<Pelicula>()
    var series = ArrayList<Pelicula>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)

        cargarPeliculas()
        cargarSeries()

        adapter = PeliculaAdapter(this, peliculas)
        seriesAdapter = PeliculaAdapter(this, series)
        var gridPelis: GridView = findViewById(R.id.movies_catalogo)
        var gridSeries: GridView = findViewById(R.id.mseries_catalogo)

        gridPelis.adapter = adapter
        gridSeries.adapter = seriesAdapter
    }

    fun cargarPeliculas(){
        peliculas.add(Pelicula("Demon Slayer: Kimetsu no Yaiba -To the Hashira Training", R.drawable.demon, R.drawable.demo, "s"))

        peliculas.add(Pelicula("Dune", R.drawable.dune, R.drawable.dune2, "s"))
        peliculas.add(Pelicula("Demon Slayer: Kimetsu no Yaiba -To the Hashira Training", R.drawable.demon, R.drawable.demo, "s"))
        peliculas.add(Pelicula("Demon Slayer: Kimetsu no Yaiba -To the Hashira Training", R.drawable.demon, R.drawable.demo, "s"))
        peliculas.add(Pelicula("Demon Slayer: Kimetsu no Yaiba -To the Hashira Training", R.drawable.demon, R.drawable.demo, "s"))
        peliculas.add(Pelicula("Demon Slayer: Kimetsu no Yaiba -To the Hashira Training", R.drawable.demon, R.drawable.demo, "s"))
    }

    fun cargarSeries(){

    }

    class PeliculaAdapter: BaseAdapter {
        var peliculas = ArrayList<Pelicula>()
        var context: Context? = null

        constructor(context: Context, peliculas: ArrayList<Pelicula>) : super() {
            this.peliculas = peliculas
            this.context = context
        }

        override fun getCount(): Int {
            return peliculas.size
        }

        override fun getItem(p0: Int): Any? {
            return  peliculas[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(pe: Int, p1: View?, p2: ViewGroup?): View {
            var pelicula = peliculas[pe]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.pelicula, null)
            var image: ImageView = vista.findViewById(R.id.image_movie_cell)
            var title: TextView = vista.findViewById(R.id.movie_title_cell)

            image.setImageResource(pelicula.image)
            title.setText(pelicula.titulo)

            image.setOnClickListener {
                val intento = Intent(context, detalle_pelicula::class.java)
                intento.putExtra("titulo", pelicula.titulo)
                intento.putExtra("imagen", pelicula.image)
                intento.putExtra("header", pelicula.header)
                intento.putExtra("sinopsis", pelicula.sinopsis)
                context!!.startActivity(intento)
            }
            return vista
        }
    }

}