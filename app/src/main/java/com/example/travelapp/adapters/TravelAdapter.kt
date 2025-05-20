package com.example.travelapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.travelapp.R
import com.example.travelapp.models.TravelDestination

class TravelAdapter(
    private val destinations: List<TravelDestination>,
    private val onItemClick: (TravelDestination) -> Unit
) : RecyclerView.Adapter<TravelAdapter.TravelViewHolder>() {

    class TravelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val placeNameTextView: TextView = itemView.findViewById(R.id.tvPlaceName)
        val countryNameTextView: TextView = itemView.findViewById(R.id.tvCountryName)
        val visitDateTextView: TextView = itemView.findViewById(R.id.tvVisitDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_travel, parent, false)
        return TravelViewHolder(view)
    }

    override fun onBindViewHolder(holder: TravelViewHolder, position: Int) {
        val destination = destinations[position]
        holder.placeNameTextView.text = destination.placeName
        holder.countryNameTextView.text = destination.countryName
        holder.visitDateTextView.text = destination.visitDate

        holder.itemView.setOnClickListener {
            onItemClick(destination)
        }
    }

    override fun getItemCount() = destinations.size
}