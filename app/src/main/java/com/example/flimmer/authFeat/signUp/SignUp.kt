package com.example.flimmer.authFeat.signUp

import Navigation.Routes
import android.widget.EditText
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
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
import com.example.flimmer.ui.theme.btnStroke
import com.example.flimmer.ui.theme.loginBtn

class SignUp {

    @Composable
    fun SignUpScreen(btnPressed: String, navController: NavController){
        var label = ""
        if (btnPressed == "Phone"){
            label = "Phone Number"
        }else{
            label = "Email Address"
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
                        PNumberEditText(label)
                        PasswordEditText(label = "Password") }
                    PasswordEditText(label = "Confirm Password")
                }

                //Implement btn functionality later
                item {
                    BtnSignUp {
                        navController.navigate(Routes.NumberAuthentication.route)
                    }
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
    fun PNumberEditText(label: String){
        var text by remember{ mutableStateOf("") }
        OutlinedTextField(value = text, onValueChange = {
            text = it}, textStyle = TextStyle(color = Color.Black), colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.White) ,shape = RoundedCornerShape(10.dp),
        label = {Text(text = label, color = Color.Gray)}, modifier = Modifier.fillMaxWidth(),
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
            .padding(top = 10.dp), textStyle = TextStyle(color = Color.Black), shape = RoundedCornerShape(10.dp), colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.White), value = text, onValueChange = { text = it },
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
    fun BtnSignUp(onClick: () -> Unit){
        Button(onClick =onClick, modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
        , shape = RoundedCornerShape(10.dp)
        , colors = ButtonDefaults.buttonColors(backgroundColor = appGreen)
        ) {
            Text(text = "Create account", fontSize = 20.sp, fontWeight = FontWeight.SemiBold, color = Color.Black
            , modifier = Modifier.padding(10.dp))
        }
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