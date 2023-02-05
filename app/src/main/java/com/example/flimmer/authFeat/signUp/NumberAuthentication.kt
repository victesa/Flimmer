package com.example.flimmer.authFeat.signUp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flimmer.R
import com.example.flimmer.ui.theme.appGreen
import com.example.flimmer.ui.theme.bg

class NumberAuthentication {

    @Composable
    fun NAuthScreen(){
        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = bg)) {
            Column(modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()
                .background(color = bg)) {
                Spacer(modifier = Modifier.height(26.dp))
                IconButton(
                    onClick = { /*TODO*/ },
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_new_24)
                )

                Spacer(modifier = Modifier.height(40.dp))
                NAuthText2(
                    text = "Enter Code",
                    color = Color.Black,
                    fontweight = FontWeight.Bold,
                    fontSize = 35
                )

                Spacer(modifier = Modifier.height(16.dp))
                NAuthText1(number = 6474849, 15 )

                NAuthBoxes()

                Spacer(modifier = Modifier.height(100.dp))

                Button(onClick = { /*TODO*/ }, modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth(), colors = ButtonDefaults.buttonColors(backgroundColor = appGreen)
                ) {
                    Text(text = "Send Code", fontWeight = FontWeight.Normal, fontSize = 20.sp, modifier = Modifier.padding(10.dp))
                }

            }
        }

    }

    @Composable
    fun IconButton(onClick:() -> Unit, painter: Painter){
        androidx.compose.material.IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.border(1.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
        ) {
            Image(
                painter = painter, contentDescription = "Icon", modifier = Modifier
                    .padding(0.dp)
                    .padding(start = 5.dp)
            )
        }
    }

    @Composable
    fun NAuthText1(number: Int, fontSize: Int){
        var number = number
        Text(buildAnnotatedString {
            withStyle(style = SpanStyle(Color.DarkGray)){
                append("we've sent an SMS with an activation code to your phone")
            }
            withStyle(style = SpanStyle(Color.Black, fontWeight = FontWeight.SemiBold)){
                append(" $number")
            }
        }, fontSize = fontSize.sp)
    }


    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun NAuthBoxes(){

        val (item1, item2, item3, item4) = remember {
            FocusRequester.createRefs()
        }


        var code1 by remember {
            mutableStateOf("")
        }
        var code2 by remember {
            mutableStateOf("")
        }
        var code3 by remember {
            mutableStateOf("")
        }
        var code4 by remember {
            mutableStateOf("")
        }


        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 70.dp), horizontalArrangement = Arrangement.Center) {
            val focusManager = LocalFocusManager.current

            OutlinedTextField(value = code1 ,
                modifier = Modifier
                    .focusRequester(item1)
                    .focusOrder {
                        next = item2
                    }
                    .width(50.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color.Black),
                maxLines = 1
                ,onValueChange ={code1 = it
                                focusManager.moveFocus(FocusDirection.Next)},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

            OutlinedTextField(value = code2,
                modifier = Modifier
                    .focusRequester(item2)
                    .padding(start = 20.dp)
                    .focusOrder {
                        next = item3
                    }
                    .width(50.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color.Black),
                maxLines = 1
                ,onValueChange ={code2 = it
                                focusManager.moveFocus(FocusDirection.Next)},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

            OutlinedTextField(value = code3,
                modifier = Modifier
                    .focusRequester(item3)
                    .padding(start = 20.dp)
                    .focusOrder {
                        next = item4
                    }
                    .width(50.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color.Black),
                maxLines = 1
                ,onValueChange ={code3 = it
                                focusManager.moveFocus(FocusDirection.Next)},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

            OutlinedTextField(value = code4,
                modifier = Modifier
                    .focusRequester(item4)
                    .padding(start = 20.dp)
                    .padding(end = 10.dp)
                    .width(50.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(10.dp),
                maxLines = 1,
                colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color.Black)
                ,onValueChange ={code4 = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))


        }

    }

    @Composable
    fun NAuthText2(text: String, color: Color, fontweight: FontWeight, fontSize: Int){
        Text(text = text, color = color, fontWeight = fontweight, fontSize = fontSize.sp)
    }

    @Composable
    fun BtnNAuth(onClick: () -> Unit){
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

    @Preview(showBackground = true)
    @Composable
    fun Preview(){
        NAuthScreen()
    }
}



