package com.justify.reciclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.justify.reciclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val listPlants = listOf<PlantsData>(
        PlantsData("Aloe Vera",
            "Aloe vera is a succulent plant species of the genus Aloe. An evergreen perennial, it originates from the Arabian Peninsula, but grows wild in tropical, semi-tropical, and arid climates around the world. It is cultivated for agricultural and medicinal uses.",
            "https://media.admagazine.com/photos/618a5ea5532cae908aaf29e1/4:3/w_2784,h_2088,c_limit/92363.jpg"),
        PlantsData("Cactus",
            "A cactus is a member of the plant family Cactaceae, a family comprising about 127 genera with some 1750 known species of the order Caryophyllales. The word cactus derives, through Latin, from the Ancient Greek κάκτος, kaktos, a name originally used by Theophrastus for a spiny plant whose identity is now not certain.",
            "https://t2.uc.ltmcdn.com/es/posts/7/1/1/tipos_de_cactus_de_interior_51117_600.jpg")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initReciclerview()
    }

    fun initReciclerview() {
        val adapter = PlantAdapter(listPlants)
        val rv = binding.recyclerView
        rv.setHasFixedSize(true)
        rv.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        rv.adapter = adapter

    }
}