package com.example.deportes

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    val deportes = listOf<TarjetaDeportes> (
        TarjetaDeportes("Baloncesto", R.drawable.baloncesto, false ),
        TarjetaDeportes("Beisbol", R.drawable.beisbol, false ),
        TarjetaDeportes("Ciclismo", R.drawable.ciclismo, false ),
        TarjetaDeportes("Fútbol", R.drawable.futbol, false ),
        TarjetaDeportes("Golf", R.drawable.golf, false ),
        TarjetaDeportes("Hípica", R.drawable.hipica, false ),
        TarjetaDeportes("Natacion", R.drawable.natacion, false ),
        TarjetaDeportes("Pinpon", R.drawable.pinpon, false ),
        TarjetaDeportes("Tenis", R.drawable.tenis, false ),
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initRecyclerView()

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab = findViewById<FloatingActionButton>(R.id.fab)

        fab.setOnClickListener {
            val deportesSeleccionados = deportes.filter { it.seleccionado }

            // Si no se ha seleccionado ningún deporte
            if (deportesSeleccionados.isEmpty()) {
                Toast.makeText(this, "No has elegido ninguna opción", Toast.LENGTH_SHORT).show()
            } else {
                // Si solo hay un deporte seleccionado
                if (deportesSeleccionados.size == 1) {
                    val mensaje = "Has elegido ${deportesSeleccionados.first().nombre}"
                    Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
                } else {
                    // Si hay más de un deporte seleccionado
                    val nombres = deportesSeleccionados.map { it.nombre }
                    val mensaje = if (nombres.size > 1) {
                        // Si hay más de dos, poner "y" entre el último y el penúltimo
                        val listaConY = nombres.dropLast(1).joinToString(", ") + " y " + nombres.last()
                        "Has elegido $listaConY"
                    } else {
                        "Has elegido ${nombres.joinToString(", ")}"
                    }
                    Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerDeportes)
        recyclerView.layoutManager =LinearLayoutManager(this)

        val adapter =TarjetaDeportesAdapter(deportes) {view ->
            val nombreDeporte =(view.findViewById<TextView>(R.id.textoDeporte)).text.toString()
        }
        recyclerView.adapter = adapter
    }
}