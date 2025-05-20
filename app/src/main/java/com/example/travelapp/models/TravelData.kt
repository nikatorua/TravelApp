package com.example.travelapp.models

object TravelData {
    val destinations = mutableListOf<TravelDestination>()

    init {
        addSampleData()
    }

    private fun addSampleData() {
        destinations.add(TravelDestination( "Paris", "France", "2023-05-15"))
        destinations.add(TravelDestination( "Rome", "Italy", "2023-06-20"))
        destinations.add(TravelDestination( "Tokyo", "Japan", "2023-07-10"))
        destinations.add(TravelDestination( "New York", "USA", "2023-08-05"))
        destinations.add(TravelDestination( "Barcelona", "Spain", "2023-09-12"))
        destinations.add(TravelDestination( "Batumi", "Georgia", "2024-08-12"))
    }
}