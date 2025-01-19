package com.rein.exploraplan

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.FirebaseStorage
import com.rein.exploraplan.databinding.ActivitySignupBinding
import com.rein.exploraplan.databinding.AddBinding
import java.time.LocalDateTime
import android.Manifest
import android.graphics.Bitmap
import android.provider.MediaStore
import android.provider.Settings
import androidx.appcompat.app.AlertDialog

class add : AppCompatActivity() {

    private lateinit var binding: AddBinding

    /*private lateinit var auth: FirebaseAuth*/

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = AddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*// Initialize Firebase Auth
        auth = Firebase.auth

        // Access a Cloud Firestore instance from your Activity
        val db = Firebase.firestore

        binding.button.setOnClickListener {

            val name = findViewById<android.widget.EditText>(R.id.editTextText2).text.toString().trim()
            val desc =
                findViewById<android.widget.EditText>(R.id.editTextTextMultiLine).text.toString().trim()
            val address =
                findViewById<android.widget.EditText>(R.id.editTextText3).text.toString().trim()
            val price =
                findViewById<android.widget.EditText>(R.id.editTextNumberDecimal).text.toString().trim()
            val open = findViewById<android.widget.EditText>(R.id.editTextTime).text.toString().trim()
            val close = findViewById<android.widget.EditText>(R.id.editTextTime2).text.toString().trim()
            val rate =
                findViewById<android.widget.EditText>(R.id.editTextNumberDecimal2).text.toString()
                    .trim()
            val imageUrl = binding.editTextText4.getText().toString().trim()

            val destinationInfo = hashMapOf(
                "name" to name,
                "description" to desc,
                "address" to address,
                "price" to price,
                "openTime" to open,
                "closeTime" to close,
                "rate" to rate,
                "imageUrl" to imageUrl,
                "createdTime" to LocalDateTime.now()
            )

            db.collection("touristSpots")
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
