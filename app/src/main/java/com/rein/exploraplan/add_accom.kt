package com.rein.exploraplan

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import com.rein.exploraplan.databinding.ActivityAddAccomBinding
import java.time.LocalDateTime

class add_accom : AppCompatActivity() {

    private lateinit var binding: ActivityAddAccomBinding

    /*private lateinit var auth: FirebaseAuth*/

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddAccomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*// Initialize Firebase Auth
        auth = Firebase.auth

        // Access a Cloud Firestore instance from your Activity
        val db = Firebase.firestore

        binding.button.setOnClickListener {

            val name = binding.editTextText2.getText().toString().trim()
            val address =binding.address.getText().toString().trim()
            val desc =  binding.editTextTextMultiLine.getText().toString().trim()
            val amenities =binding.amenities.getText().toString().trim()
            val features =binding.features.getText().toString().trim()
            val roomType =binding.editTextText3.getText().toString().trim()
            val price = binding.editTextNumberDecimal.getText().toString().trim()
            val rate = binding.rate.getText().toString().trim()
            val hotelLink = binding.editTextTime.getText().toString().trim()
            val bookLink = binding.editTextTime2.getText().toString().trim()
            val imageUrl = binding.editTextText4.getText().toString().trim()

            val destinationInfo = hashMapOf(
                "name" to name,
                "address" to address,
                "description" to desc,
                "amenities" to amenities,
                "features" to features,
                "roomType" to roomType,
                "price" to price,
                "rate" to rate,
                "hotelLink" to hotelLink,
                "bookLink" to bookLink,
                "imageUrl" to imageUrl,
                "createdTime" to LocalDateTime.now()
            )

            db.collection("accommodation")
                .document()
                .set(destinationInfo)
                .addOnSuccessListener {
                    Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Failed to save data: ${e.message}", Toast.LENGTH_SHORT).show()
                }
        }*/
    }
}