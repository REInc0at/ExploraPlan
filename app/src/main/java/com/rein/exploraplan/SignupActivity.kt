package com.rein.exploraplan

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import com.rein.exploraplan.databinding.ActivitySignupBinding
import java.time.LocalDateTime


class SignupActivity  : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    private lateinit var sharedPref: SharedPreferences

    /*private lateinit var auth: FirebaseAuth*/

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*// Initialize Firebase Auth
        auth = Firebase.auth

        // Access a Cloud Firestore instance from your Activity
        val db = Firebase.firestore

        val editPword = findViewById<ClickableDrawableEditText>(R.id.editPassword)
        val editCPword = findViewById<ClickableDrawableEditText>(R.id.editConPassword)

        binding.regBtn.setOnClickListener{

            // Get user input
            val uname = binding.editName.getText().toString().trim()
            val email = binding.editEmail.getText().toString().trim()
            val password = binding.editPassword.getText().toString().trim()
            val cPassword = binding.editConPassword.getText().toString().trim()

            if (uname.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && cPassword.isNotEmpty()) {
                if (password == cPassword) {
                    auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success")
                                val user = auth.currentUser

                                val userId = user?.uid ?: return@addOnCompleteListener

                                // Get additional info
                                val currentTimestamp = LocalDateTime.now()
                                val userRole = "user"

                                // Create a new user
                                val userInfo = hashMapOf (
                                    "username" to uname,
                                    "email" to email,
                                    "password" to password,
                                    "userRole" to userRole,
                                    "createdTime" to currentTimestamp
                                )

                                // Save user info to Firestore with UID as the document ID
                                db.collection("user")
                                    .document(userId)
                                    .set(userInfo)
                                    .addOnSuccessListener {
                                        Toast.makeText(this, "WELCOME TO EXPLORAPLAN",Toast.LENGTH_SHORT).show()

                                        //updateUI(user)
                                        val intent = Intent(this, Home::class.java)
                                        startActivity(intent)
                                        finish()
                                    }

                                    .addOnFailureListener { e ->
                                        Log.e(TAG, "Error saving user data to Firestore", e)
                                        Toast.makeText(this, "Failed to save user info",Toast.LENGTH_SHORT).show()
                                    }

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.exception)
                                Toast.makeText(
                                    baseContext,
                                    "Authentication failed: ${task.exception?.message}",
                                    Toast.LENGTH_SHORT,
                                ).show()
                                //updateUI(null)
                            }
                        }

                } else {
                    Toast.makeText(this, "Password does not matched", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            }

        }*/

        sharedPref = applicationContext.getSharedPreferences("DataPrefs", Context.MODE_PRIVATE)

        binding.toSignInBtn.setOnClickListener {
            val signInIntent = Intent(this, SigninActivity::class.java)
            startActivity(signInIntent)
        }


        val editUname: EditText = findViewById(R.id.editName)
        val editEmail: EditText = findViewById(R.id.editEmail)

        val editPword = findViewById<ClickableDrawableEditText>(R.id.editPassword)
        val editCPword = findViewById<ClickableDrawableEditText>(R.id.editConPassword)

        //Registration
        binding.regBtn.setOnClickListener {

            val username = editUname.text.toString().trim()
            val email = editEmail.text.toString().trim()
            val password = editPword.text.toString().trim()
            val cpassword = editCPword.text.toString().trim()

            //Verifies if the textboxes is null and save the inputted data into SharedPreferences
            if ((username.isNotEmpty() && email.isNotEmpty()) && (password.isNotEmpty() && cpassword.isNotEmpty())){

                val savedUsername = sharedPref.getString("username", "")

                if (username == savedUsername){
                    Toast.makeText(this, "Already has this username!", Toast.LENGTH_SHORT).show()

                    editUname.setText("")
                    editEmail.setText("")
                    editPword.setText("")
                    editCPword.setText("")
                }
                else{
                    if (cpassword == password){
                        val editor = sharedPref.edit()

                        editor.putString("username", username)
                        editor.putString("email", email)
                        editor.putString("password", password)
                        editor.apply()

                        val homeIntent = Intent(this, Home::class.java)

                        startActivity(homeIntent)
                    }
                    else{
                        Toast.makeText(this, "Your input for confirm password is not the same with the password.", Toast.LENGTH_SHORT).show()

                        editUname.setText("")
                        editEmail.setText("")
                        editPword.setText("")
                        editCPword.setText("")
                    }
                }
            }
            else {
                Toast.makeText(this, "Please fill out all text box!", Toast.LENGTH_SHORT).show()

                editUname.setText("")
                editEmail.setText("")
                editPword.setText("")
                editCPword.setText("")
            }
        }

        editPword.setDrawableEndClickListener(object : ClickableDrawableEditText.DrawableEndClickListener {
            override fun onDrawableEndClick() {
                // Toggle password visibility
                editPword.transformationMethod =
                    if (editPword.transformationMethod == null) PasswordTransformationMethod.getInstance()
                    else null
                editPword.setSelection(editPword.text.toString().length)
            }
        })

        editCPword.setDrawableEndClickListener(object : ClickableDrawableEditText.DrawableEndClickListener {
            override fun onDrawableEndClick() {
                // Toggle password visibility
                editCPword.transformationMethod =
                    if (editCPword.transformationMethod == null) PasswordTransformationMethod.getInstance()
                    else null
                editCPword.setSelection(editCPword.text.toString().length)
            }
        })
    }

    /*public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }*/

}