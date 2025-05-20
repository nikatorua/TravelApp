package com.example.travelapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.travelapp.R
import com.example.travelapp.adapters.TravelAdapter
import com.example.travelapp.models.TravelData

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var travelAdapter: TravelAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recyclerView = view.findViewById(R.id.recyclerViewTravels)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        updateList()
    }

    override fun onResume() {
        super.onResume()
        updateList()
    }

    private fun updateList() {
        travelAdapter = TravelAdapter(TravelData.destinations) { destination ->
        }
        recyclerView.adapter = travelAdapter
    }
}