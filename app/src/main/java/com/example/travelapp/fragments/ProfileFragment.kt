package com.example.travelapp.fragments

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.travelapp.R
import com.example.travelapp.models.TravelData

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var nameTextView: TextView
    private lateinit var bioTextView: TextView
    private lateinit var countriesCountTextView: TextView
    private lateinit var placesCountTextView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameTextView = view.findViewById(R.id.tvName)
        bioTextView = view.findViewById(R.id.tvBio)
        countriesCountTextView = view.findViewById(R.id.tvCountriesCount)
        placesCountTextView = view.findViewById(R.id.tvPlacesCount)

        nameTextView.text = getString(R.string.traveler)
        bioTextView.text = getString(R.string.bio)

        updateStatistics()
    }

    override fun onResume() {
        super.onResume()
        updateStatistics()
    }

    private fun updateStatistics() {
        val uniqueCountries = TravelData.destinations.map { it.countryName }.toSet()
        countriesCountTextView.text = uniqueCountries.size.toString()

        placesCountTextView.text = TravelData.destinations.size.toString()
    }
}