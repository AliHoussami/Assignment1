package com.example.assigment1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListActivity : ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    private val itemList = mutableListOf(
        "Apple", "Banana", "Cherry", "Date", "Elderberry", "Fig", "Grapes", "Honeydew"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Setup adapter with click and remove functionality
        adapter = ItemAdapter(
            itemList,
            onItemClick = { item ->
                Toast.makeText(this, "Clicked on $item", Toast.LENGTH_SHORT).show()
            },
            onItemRemove = { position ->
                adapter.removeItem(position)
                Toast.makeText(this, "Item removed", Toast.LENGTH_SHORT).show()
            }
        )

        recyclerView.adapter = adapter
    }
}