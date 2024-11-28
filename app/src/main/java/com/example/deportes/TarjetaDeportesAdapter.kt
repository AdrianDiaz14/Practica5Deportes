package com.example.deportes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TarjetaDeportesAdapter(var listaDeportes: List<TarjetaDeportes>, val onClick: (View) -> Unit) : RecyclerView.Adapter<TarjetaDeportesAdapter.TarjetaDeportesViewHolder>() {

    class TarjetaDeportesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombre = view.findViewById<TextView>(R.id.textoDeporte)
        val check = view.findViewById<CheckBox>(R.id.checkBox)
        val imagen = view.findViewById<ImageView>(R.id.imagenDeporte)

        fun render(deportesModel: TarjetaDeportes, onClick: (View) -> Unit) = with(itemView){
            nombre.text = deportesModel.nombre
            check.isChecked = deportesModel.seleccionado
            imagen.setImageResource(deportesModel.imagen)

            check.setOnClickListener {
                deportesModel.seleccionado = check.isChecked
            }

            setOnClickListener{ onClick(itemView)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarjetaDeportesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_deportes, parent, false)
        return TarjetaDeportesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaDeportes.size
    }

    override fun onBindViewHolder(holder: TarjetaDeportesViewHolder, position: Int) {
        val item =listaDeportes[position]
        holder.render(item, onClick)
    }

}