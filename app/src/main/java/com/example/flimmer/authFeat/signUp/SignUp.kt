package com.example.flimmer.authFeat.signUp

import android.content.ContentValues.TAG
import android.content.DialogInterface
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.flimmer.R
import com.example.flimmer.authFeat.AuthViewModal
import com.example.flimmer.ui.theme.appGreen
import com.example.flimmer.ui.theme.bg

class SignUp {
    private var label = ""
    private var keyBoardInputTType: KeyboardType? = null

    @Composable
    fun SignUpScreen(btnPressed: String, navController: NavController){

        if (btnPressed == "Phone"){
            label = "Phone Number"
             keyBoardInputTType = KeyboardType.Number
        }else{
            label = "Email Address"
            keyBoardInputTType = KeyboardType.Email
        }
        Card(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            , elevation = 0.dp
        , shape = RoundedCornerShape(20.dp)
        , backgroundColor = bg
        ) {
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)){
                item {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        , horizontalAlignment = Alignment.CenterHorizontally) {
                        SignUpPic(painter = painterResource(id = R.drawable.ic_task_image))
                    }

                }
                item{
                    Spacer(modifier = Modifier.height(10.dp))
                }

                item {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)) {
                        SignUpText(text = "Create account", color = Color.Black, fontweight = FontWeight.Bold, fontSize = 35)
                    }
                }
                
                items(1){
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)) {
                    }
                    PNumberEditText(label = label, keyBoard = keyBoardInputTType!!)
                    PasswordsWditText()

                }

                //Implement btn functionality later
                item {
                    BtnSignUp (navController)
                }

                item {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                        Line()
                        Text(text = "Or Continue with", color = Color.DarkGray, fontSize = 15.sp, modifier = Modifier.padding(horizontal = 10.dp))
                        Line()
                    }
                }
                
                item { 
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                        .padding(top = 40.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
                        IconButtons(onClick = { /*TODO*/ }, painter = painterResource(id = R.drawable.facebook_logo))
                        IconButtons(onClick = { /*TODO*/ }, painter = painterResource(id = R.drawable.google_logo))
                        IconButtons(onClick = { /*TODO*/ }, painter = painterResource(id = R.drawable.apple_logo))
                    }
                }
                
                item { 
                    Spacer(modifier = Modifier.height(60.dp))
                }
            }
        }
    }

    @Composable
    fun Line(){
        Column {
            Divider(modifier = Modifier.size(width = 70.dp, height = 1.dp))
        }
    }

    @Composable
    fun SignUpPic(painter: Painter){
            Image(painter = painter, contentDescription = "Image", contentScale = ContentScale.FillWidth, modifier = Modifier.size(250.dp))


    }


    @Composable
    fun PNumberEditText(label: String, keyBoard: KeyboardType){
        val viewModal = viewModel(AuthViewModal()::class.java)
        val email = viewModal.email.collectAsState()
        val phoneNumber = viewModal.phoneNumber.collectAsState()

        val value = if (label == "Email"){
            email.value
        }else{
            phoneNumber.value
        }



        OutlinedTextField(value = value,
            onValueChange = {if (value == email.value){viewModal.setEmail(it)}else{viewModal.setPhoneNumer(it)} }
            , textStyle = TextStyle(color = Color.Black),
            colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.White) ,
            shape = RoundedCornerShape(10.dp),
        label = {Text(text = label, color = Color.Gray)}, modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = keyBoard )
        )
    }


    @Composable
    fun PasswordsWditText(){
        val viewModal = viewModel(modelClass = AuthViewModal::class.java)
        val password = viewModal.password.collectAsState()
        var vissibilityDrawable_1 by remember {
            mutableStateOf(R.drawable.ic_baseline_visibility_24)
        }
        var vissibilityDrawable_2 by remember {
            mutableStateOf(R.drawable.ic_baseline_visibility_24)
        }
        val confirmPassword = viewModal.confirmPassword.collectAsState()
        var isVissible1 by remember {
            mutableStateOf(false)
        }

        var isVissible2 by remember {
            mutableStateOf(false)
        }
        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp), textStyle = TextStyle(color = Color.Black), shape = RoundedCornerShape(10.dp), colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.White),
            value = password.value , onValueChange = {viewModal.setPassword(it)},
            label = { Text(text = "Password", color = Color.Gray)},
            trailingIcon = {
                IconButton(onClick = { isVissible1 = !isVissible1 }) {
                    vissibilityDrawable_1 = if (!isVissible1){
                        R.drawable.ic_baseline_visibility_off_24
                    }else{
                        R.drawable.ic_baseline_visibility_24
                    }
                    Icon(painter = painterResource(id = vissibilityDrawable_1), contentDescription = "visibility")
                }
            }
            , visualTransformation = if (isVissible1){
                VisualTransformation.None
            }else{
                PasswordVisualTransformation()
            })

        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp), textStyle = TextStyle(color = Color.Black), shape = RoundedCornerShape(10.dp), colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.White),
            value = confirmPassword.value, onValueChange = {viewModal.setConfirmPassword(it) },
            label = { Text(text = "Confirm Password", color = Color.Gray)},
            trailingIcon = {
                IconButton(onClick = { isVissible2 = !isVissible2 }) {
                    vissibilityDrawable_2 = if (!isVissible2){
                        R.drawable.ic_baseline_visibility_off_24
                    }else{
                        R.drawable.ic_baseline_visibility_24
                    }
                    Icon(painter = painterResource(id = vissibilityDrawable_2), contentDescription = "visibility")
                }
            }
            , visualTransformation = if (isVissible2){
                VisualTransformation.None
            }else{
                PasswordVisualTransformation()
            })
    }

    @Composable
    fun ProgressDialog(state: Boolean){
        Dialog(onDismissRequest = {},
        DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Box(modifier = Modifier
                .size(100.dp)
                .background(Color.White, shape = RoundedCornerShape(10.dp))){
                Column {
                    CircularProgressIndicator(modifier = Modifier.padding(start = 6.dp))
                    Text(text = "Signing In", modifier = Modifier.padding(top = 8.dp))
                }
            }
        }
    }


    @Composable
    fun BtnSignUp( navController: NavController){
        var context = LocalContext.current
        var state = false
        var viewModal = viewModel(AuthViewModal::class.java)
        Button(onClick ={
            state = true
            viewModal.registerUser(context)
            state = false
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
        , shape = RoundedCornerShape(10.dp)
        , colors = ButtonDefaults.buttonColors(backgroundColor = appGreen)
        ) {
            Text(text = "Create account", fontSize = 20.sp, fontWeight = FontWeight.SemiBold, color = Color.Black
            , modifier = Modifier.padding(10.dp))
        }
        ProgressDialog(state = state)
    }

    @Composable
    fun SignUpText(text: String, color: Color, fontweight: FontWeight, fontSize: Int){
        Text(text = text, color = color, fontWeight = fontweight, fontSize = fontSize.sp)
    }
    
    @Composable
    fun IconButtons(onClick:() -> Unit, painter: Painter){
        IconButton(onClick = { /*TODO*/ },
            modifier = Modifier.border(1.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))) {
            Image(painter = painter, contentDescription = "Icon", modifier = Modifier
                .padding(20.dp)
                .padding(horizontal = 10.dp))
        }
    }




    @Preview(showBackground = true)
    @Composable
    fun Preview(){

    }
}