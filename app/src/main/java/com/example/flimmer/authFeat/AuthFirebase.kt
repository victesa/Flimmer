package com.example.flimmer.authFeat

import Navigation.Routes
import android.app.Dialog
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.flimmer.authFeat.signUp.SignUp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthFirebase {
    private var auth = Firebase.auth

    fun createUser(email: String, password: String, context: Context){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
                }
            }
    }






}