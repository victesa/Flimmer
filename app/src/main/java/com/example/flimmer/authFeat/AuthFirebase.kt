package com.example.flimmer.authFeat

import Navigation.Routes
import android.util.Log
import androidx.navigation.NavController
import com.example.flimmer.authFeat.signUp.SignUp
import com.google.firebase.auth.FirebaseAuth

class AuthFirebase {
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    var password1: String? = null
    var password2: String? = null

    fun registerUser(email: String, password: String, activity: SignUp , navController: NavController){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful){
                }
            }
    }




}