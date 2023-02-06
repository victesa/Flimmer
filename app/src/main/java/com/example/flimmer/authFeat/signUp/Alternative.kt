package com.example.flimmer.authFeat.signUp

import Navigation.Routes
import android.content.ContentValues.TAG
import android.graphics.fonts.Font
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.flimmer.R
import com.example.flimmer.authFeat.AuthViewModal
import com.example.flimmer.ui.theme.bg
import org.w3c.dom.Text

class Alternative {

    @Composable
    fun AlternativeScreen(navController: NavController){
        var viewModel: AuthViewModal = viewModel()
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(16.dp))
            CardView(navController = navController, viewModel)
        }
    }

    @Composable
    fun CardView(navController: NavController, viewModel: AuthViewModal){
        Card(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.85f), backgroundColor = bg, shape = RoundedCornerShape(32.dp)
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                ImageCard()

                Spacer(modifier = Modifier.height(10.dp))
                AlternativeTextViews(text = "Explore the app", fontSize = 33, fontWeight = FontWeight.ExtraBold, color = Color.Black)

                Spacer(modifier = Modifier.height(10.dp))
                AlternativeTextViews(text = "Supervise your work progress", fontSize = 20, fontWeight = FontWeight.Normal, color = Color.DarkGray )
                AlternativeTextViews(text = "with the best software", fontSize = 20, fontWeight = FontWeight.Normal, color = Color.DarkGray)

                Spacer(modifier = Modifier.height(20.dp))
                AlternativeButtons(painter = painterResource(id = R.drawable.phone), text = "continue with Phone",
                    onClick = { navController.navigate("${Routes.SignUp.route}/Phone")
                    })
                AlternativeButtons(painter = painterResource(id = R.drawable.email), text = "continue with Email",
                    onClick = {navController.navigate("${Routes.SignUp.route}/Email") })
                AlternativeButtons(painter = painterResource(id = R.drawable.facebook_logo), text = "continue with facebook",
                onClick = {})

            }
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp), horizontalArrangement = Arrangement.Center) {
            Text(text = "Already have an account?", fontSize = 15.sp, color = Color.DarkGray)
            TextLogIn()

        }
    }

    @Composable
    fun AlternativeButtons(painter: Painter, text: String, onClick:() -> Unit){
        Button(onClick = onClick, modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White), shape = RoundedCornerShape(20.dp), elevation = ButtonDefaults.elevation(0.dp), border = ButtonDefaults.outlinedBorder,
        ) {
           Row(modifier = Modifier.fillMaxWidth().padding(5.dp).height(intrinsicSize = IntrinsicSize.Min), horizontalArrangement = Arrangement.Start) {
               Image(painter = painter, contentDescription = "Image", modifier = Modifier
                   .padding(5.dp)
                   .padding(end = 10.dp))
               Text(text = text, fontSize = 16.sp, modifier = Modifier.padding(5.dp).padding(horizontal = 10.dp))
           }
        }
    }

    @Composable
    fun AlternativeTextViews(text: String, fontSize: Int, fontWeight: FontWeight, color: Color){
        Text(text = text, fontSize = fontSize.sp, fontWeight = fontWeight, modifier = Modifier
            .fillMaxWidth()
            , color = color,
            textAlign = TextAlign.Center)
    }

    @Composable
    fun ImageCard(){
        Image(painter = painterResource(id = R.drawable.img), contentDescription = "Image",
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxWidth()
            .fillMaxHeight(0.4f), contentScale = ContentScale.Fit)
    }

    @Composable
    fun TextLogIn(){
        Text(text = "Log in", fontSize = 15.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier
            .padding(horizontal = 10.dp))
    }


    @Preview(showBackground = true)
    @Composable
    fun Preview(){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)) {
            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}