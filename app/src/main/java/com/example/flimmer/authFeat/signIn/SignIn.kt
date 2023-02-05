package com.example.flimmer.authFeat.signIn

import Navigation.Routes
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flimmer.R
import com.example.flimmer.ui.theme.appGreen
import com.example.flimmer.ui.theme.bg

class SignIn {

    @Composable
    fun SignInScreen(){
        Card(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        shape = RoundedCornerShape(20.dp), backgroundColor = bg
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()){
                items(1) {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .padding(horizontal = 10.dp)) {
                        Spacer(modifier = Modifier.height(40.dp))

                        IconButton(onClick = {  }, painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_24))
                        
                        Spacer(modifier = Modifier.height(30.dp))
                        SignInText(text = "Log in", color = Color.Black, fontweight = FontWeight.Bold, fontSize = 35)
                        Spacer(modifier = Modifier.height(20.dp))
                        SignInText(text = "Enter your Phone Number and Password below", color = Color.DarkGray, fontweight = FontWeight.Normal , fontSize = 15)
                        
                        Spacer(modifier = Modifier.height(40.dp))
                        PNumberEditText()
                        
                        PasswordEditText(label = "Password")
                        
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp), horizontalArrangement = Arrangement.End) {
                            SignInText(text = "Forgot Password?", color = Color.DarkGray, fontweight = FontWeight.Normal, fontSize = 15)
                            Text(text = "Reset", modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .clickable { }, color = Color.Black, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                        }
                        
                        Spacer(modifier = Modifier.padding(top = 20.dp))
                        
                        BtnSignIn {
                            
                        }
                        
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp), horizontalArrangement = Arrangement.End) {
                            SignInText(text = "Don't have an account?", color = Color.DarkGray, fontweight = FontWeight.Normal, fontSize = 15)
                            
                            Text(text = "Sign Up", color = Color.DarkGray, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 10.dp))
                        }

                        Row(modifier = Modifier
                            .padding(top = 50.dp)
                            .fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                            Line()
                            SignInText(text = "Or Continue with", color = Color.DarkGray, fontweight = FontWeight.Normal, fontSize = 15)
                            Line()
                        }

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 40.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
                            IconButtons(onClick = { /*TODO*/ }, painter = painterResource(id = R.drawable.facebook_logo))
                            IconButtons(onClick = { /*TODO*/ }, painter = painterResource(id = R.drawable.email))
                            IconButtons(onClick = { /*TODO*/ }, painter = painterResource(id = R.drawable.google_logo))
                        }
                        
                        Spacer(modifier = Modifier.height(60.dp))
                    }
                }

            }
        }
    }

    @Composable
    fun Line(){
        Column {
            Divider(modifier = Modifier
                .size(width = 100.dp, height = 1.dp)
                .padding(horizontal = 10.dp))
        }
    }

    @Composable
    fun PNumberEditText(){
        var text by remember{ mutableStateOf("") }
        OutlinedTextField(value = text, onValueChange = {
            text = it}, textStyle = TextStyle(color = Color.Black), colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.White) ,shape = RoundedCornerShape(10.dp),
            label = { Text(text = "Phone number", color = Color.Gray) }, modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }

    @Composable
    fun PasswordEditText(label: String){
        var text by remember{ mutableStateOf("") }
        var isVissible by remember{ mutableStateOf(false) }

        var icon = if (isVissible){
            painterResource(id = R.drawable.ic_baseline_visibility_24)
        }else{
            painterResource(id = R.drawable.ic_baseline_visibility_off_24)

        }
        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp), textStyle = TextStyle(color = Color.Black), shape = RoundedCornerShape(10.dp), colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.White), value = text, onValueChange = { text = it },
            label = { Text(text = label, color = Color.Gray)},
            trailingIcon = {
                IconButton(onClick = { isVissible = !isVissible }) {
                    Icon(painter = icon, contentDescription = "visibility")
                }
            }
            , visualTransformation = if (isVissible){
                VisualTransformation.None
            }else{
                PasswordVisualTransformation()
            })
    }

    @Composable
    fun BtnSignIn(onClick: () -> Unit){
        Button(onClick =onClick, modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
            , shape = RoundedCornerShape(10.dp)
            , colors = ButtonDefaults.buttonColors(backgroundColor = appGreen)
        ) {
            Text(text = "Sign In", fontSize = 20.sp, fontWeight = FontWeight.Normal, color = Color.Black
                , modifier = Modifier.padding(5.dp))
        }
    }

    @Composable
    fun SignInText(text: String, color: Color, fontweight: FontWeight, fontSize: Int){
        Text(text = text, color = color, fontWeight = fontweight, fontSize = fontSize.sp)
    }

    @Composable
    fun IconButton(onClick:() -> Unit, painter: Painter){
        IconButton(onClick = { /*TODO*/ },
            modifier = Modifier.border(1.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))) {
            Image(painter = painter, contentDescription = "Icon", modifier = Modifier
                .padding(0.dp)
                .padding(start = 5.dp))
        }
    }


    @Composable
    fun IconButtons(onClick:() -> Unit, painter: Painter){
        IconButton(onClick = { /*TODO*/ },
            modifier = Modifier.border(1.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp)).height(intrinsicSize = IntrinsicSize.Min)) {
            Image(painter = painter, contentDescription = "Icon", modifier = Modifier
                .padding(10.dp)
                .padding(horizontal = 10.dp))
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun Preview(){
    }
}