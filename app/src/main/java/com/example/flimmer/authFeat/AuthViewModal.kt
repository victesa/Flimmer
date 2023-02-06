package com.example.flimmer.authFeat

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect

class AuthViewModal: ViewModel() {

    var auth = Firebase.auth

    private var _email = MutableStateFlow("")
    var email = _email.asStateFlow()

    private var _phoneNumber = MutableStateFlow("")
    var phoneNumber = _phoneNumber.asStateFlow()

    private var _password = MutableStateFlow("")
    var password = _password.asStateFlow()

    private var _confirmPassword = MutableStateFlow("")
    var confirmPassword = _confirmPassword.asStateFlow()

    fun setConfirmPassword(confirmPassword: String){
        _confirmPassword.value = confirmPassword
    }

    fun setPassword(password: String){
        _password.value = password
    }

    fun setPhoneNumer(phoneNumber: String){
        _phoneNumber.value = phoneNumber
    }

    fun setEmail(email: String){
        _email.value = email
    }

    private fun validateForm(context: Context): Boolean{
        return if (email.value.isEmpty() || password.value.isEmpty() || confirmPassword.value.isEmpty()){
            Toast.makeText(context, "Fill in the blanks", Toast.LENGTH_SHORT).show()
            false
        }else if (password.value != confirmPassword.value){
            Toast.makeText(context, "Fill in the blanks", Toast.LENGTH_SHORT).show()
            false
        }else{
            true
        }
    }

    fun registerUser(context: Context){
        if (validateForm(context)){
            AuthFirebase().createUser(email.value, password.value, context)
        }
    }



}