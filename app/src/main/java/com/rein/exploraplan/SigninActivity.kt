package com.rein.exploraplan

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
/*import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth*/
import com.rein.exploraplan.databinding.ActivitySigninBinding

class SigninActivity : AppCompatActivity() {

    private lateinit var sharedPref: SharedPreferences

    private lateinit var binding: ActivitySigninBinding

    /*private lateinit var auth: FirebaseAuth*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editPassword = findViewById<ClickableDrawableEditText>(R.id.editPassword)

        /*// Initialize Firebase Auth
        auth = Firebase.auth

        binding.signinBtn.setOnClickListener {

            // Get user input
            val email = binding.editEmail.getText().toString().trim()
            val password = binding.editPassword.getText().toString().trim()

            // Validate inputs
            if (email.isEmpty()) {
                binding.editEmail.error = "Email is required"
                binding.editEmail.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                binding.editPassword.error = "Password is required"
                binding.editPassword.requestFocus()
                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")
                        val user = auth.currentUser

                        //updateUI(user)
                        val intent = Intent(this, Home::class.java)
                        startActivity(intent)
                        finish()

                    } else {

                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                        //updateUI(null)
                    }
                }
        }*/

        sharedPref = applicationContext.getSharedPreferences("DataPrefs", Context.MODE_PRIVATE)

        binding.signinBtn. setOnClickListener {

            val email = binding.editEmail.getText().toString().trim()
            val password = binding.editPassword.getText().toString().trim()

            //Verifies if the textboxes is null and save the inputted data into SharedPreferences
            if (email.isNotEmpty() && password.isNotEmpty()){
                val savedEmail = sharedPref.getString("email", "")
                val savedPassword = sharedPref.getString("password", "")

                if (email == savedEmail && password == savedPassword){
                    val homeIntent = Intent(this, Home::class.java)

                    startActivity(homeIntent)
                }
                else{
                    Toast.makeText(this, "Incorrect Password or Username!", Toast.LENGTH_SHORT).show()
                    binding.editEmail.setText("")
                    binding.editPassword.setText("")
                }
            }
            else{
                Toast.makeText(this, "Please fill out all text box!", Toast.LENGTH_SHORT).show()

                binding.editEmail.setText("")
                binding.editPassword.setText("")
            }
        }

        binding.toRegisterBtn.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        binding.toForgotPasswordBtn.setOnClickListener {
            val forintent = Intent(this, addSouv::class.java)
            startActivity(forintent)
        }

        editPassword.setDrawableEndClickListener(object : ClickableDrawableEditText.DrawableEndClickListener {
            override fun onDrawableEndClick() {
                // Toggle password visibility
                editPassword.transformationMethod =
                    if (editPassword.transformationMethod == null) PasswordTransformationMethod.getInstance()
                    else null
                editPassword.setSelection(editPassword.text.toString().length)
            }
        })

    }

/*

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }*/

}