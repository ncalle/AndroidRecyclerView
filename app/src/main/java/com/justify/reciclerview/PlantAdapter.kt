package com.justify.reciclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PlantAdapter (val listPlants: List<PlantsData>): RecyclerView.Adapter<PlantAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: PlantAdapter.ViewHolder, position: Int) {
        holder.render(listPlants[position])
    }

    override fun getItemCount(): Int {
        return listPlants.size
    }

    class ViewHolder (val itemView: View): RecyclerView.ViewHolder(itemView) {
        
        fun render(plantsData: PlantsData) {
            Picasso.get().load(plantsData.image).into(itemView.findViewById<ImageView>(R.id.image))
            itemView.findViewById<TextView>(R.id.tvName).text = plantsData.name
            itemView.findViewById<TextView>(R.id.tvDesc).text = plantsData.description

            itemView.setOnClickListener{
                Toast.makeText(itemView.context, plantsData.name, Toast.LENGTH_SHORT).show()
            }
        }
    }
}