package com.example.travelapp.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.travelapp.R
import com.example.travelapp.models.TravelData
import com.example.travelapp.models.TravelDestination
import java.util.Calendar

class AddFragment : Fragment(R.layout.fragment_add) {

    private lateinit var placeNameEditText: EditText
    private lateinit var countryNameEditText: EditText
    private lateinit var visitDateEditText: EditText
    private lateinit var addButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        placeNameEditText = view.findViewById(R.id.etPlaceName)
        countryNameEditText = view.findViewById(R.id.etCountryName)
        visitDateEditText = view.findViewById(R.id.etVisitDate)
        addButton = view.findViewById(R.id.btnAddTravel)

        visitDateEditText.setOnClickListener {
            showDatePicker()
        }

        addButton.setOnClickListener {
            addTravelDestination()
        }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = "$selectedYear-${selectedMonth + 1}-$selectedDay"
                visitDateEditText.setText(selectedDate)
            },
            year,
            month,
            day
        )

        datePickerDialog.show()
    }

    private fun addTravelDestination() {
        val placeName = placeNameEditText.text.toString().trim()
        val countryName = countryNameEditText.text.toString().trim()
        val visitDate = visitDateEditText.text.toString().trim()

        if (placeName.isEmpty() || countryName.isEmpty() || visitDate.isEmpty()) {
            Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val newDestination = TravelDestination(
            placeName = placeName,
            countryName = countryName,
            visitDate = visitDate
        )

        TravelData.destinations.add(newDestination)

        Toast.makeText(requireContext(), "Travel destination added!", Toast.LENGTH_SHORT).show()

        clearInputFields()
    }

    private fun clearInputFields() {
        placeNameEditText.text.clear()
        countryNameEditText.text.clear()
        visitDateEditText.text.clear()
        placeNameEditText.requestFocus()
    }
}