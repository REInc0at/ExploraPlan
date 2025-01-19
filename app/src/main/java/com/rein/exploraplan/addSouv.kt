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
import com.rein.exploraplan.databinding.ActivityAddSouvBinding
import java.time.LocalDateTime

class addSouv : AppCompatActivity() {

    private lateinit var binding: ActivityAddSouvBinding

    /*private lateinit var auth: FirebaseAuth*/
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*binding = ActivityAddSouvBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = Firebase.auth

        // Access a Cloud Firestore instance from your Activity
        val db = Firebase.firestore

        binding.button.setOnClickListener {

            val name = binding.editTextText2.getText().toString().trim()
            val desc =  binding.editTextTextMultiLine.getText().toString().trim()
            val address =binding.editTextText3.getText().toString().trim()
            val amnneties = binding.editTextNumberDecimal.getText().toString().trim()
            val open = binding.editTextTime.getText().toString().trim()
            val close = binding.editTextTime2.getText().toString().trim()
            val rate = binding.editTextNumberDecimal2.getText().toString().trim()
            val imageUrl = binding.editTextText4.getText().toString().trim()

            val destinationInfo = hashMapOf(
                "name" to name,
                "description" to desc,
                "address" to address,
                "amnneties" to amnneties,
                "openTime" to open,
                "closeTime" to close,
                "rate" to rate,
                "imageUrl" to imageUrl,
                "createdTime" to LocalDateTime.now()
            )

            db.collection("souvenirShops")
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