package Screens

import Navigation.Navigation
import Navigation.Routes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.flimmer.ui.theme.bg
import com.example.flimmer.ui.theme.loginBtn

class StartScreen() {



    @Composable
    fun StartApp(navController: NavController){

        ConstraintLayout(modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .background(color = bg)) {
            val (cardview, text1, text2, buttons) = createRefs()


            Column(modifier = androidx.compose.ui.Modifier
                .padding(horizontal = 10.dp)
                .constrainAs(cardview)
                { top.linkTo(parent.top, margin = 40.dp) }) {
                Cardview(painter = painterResource(id = com.example.flimmer.R.drawable.ic_task_image))
            }

            Column(modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .constrainAs(text1) {
                    top.linkTo(cardview.bottom, margin = 40.dp)
                }, horizontalAlignment = Alignment.CenterHorizontally) {
                StartText(text = "Discover your", color = Color.Black, fontSize = 30, fontWeight = FontWeight.Bold)
                StartText(text = "Pros And Cons here", color = Color.Black, fontSize = 30, fontWeight = FontWeight.Bold)
            }


            Column(modifier = Modifier
                .fillMaxWidth()
                .constrainAs(text2) {
                    top.linkTo(text1.bottom, margin = 20.dp)
                }, horizontalAlignment = Alignment.CenterHorizontally) {
                StartText(text = "Supervise your work progress", color = Color.Gray, fontSize = 20, fontWeight = FontWeight.Normal)
                StartText(text = "with the best software", color = Color.Gray, fontSize = 20, fontWeight = FontWeight.Normal)
            }

            Column(modifier = Modifier.constrainAs(buttons)
            { bottom.linkTo(parent.bottom, margin = 80.dp) }) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    StartButtons(navController = navController)
                }

            }
        }

    }

    @Composable
    fun StartButtons(navController: NavController){
        var color by remember{
            mutableStateOf(Color.Transparent)
        }
        Row(modifier = androidx.compose.ui.Modifier
            .border(2.dp, color = Color.White, RoundedCornerShape(10.dp))
            .background(shape = RoundedCornerShape(10.dp), color = loginBtn), verticalAlignment = Alignment.CenterVertically) {

            Button(onClick = { navController.navigate(Routes.Alternative.route) }
                ,colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                ,shape = RoundedCornerShape(10.dp),
                modifier = androidx.compose.ui.Modifier.shadow(0.dp), elevation = ButtonDefaults.elevation(0.dp)
            ) {
                Text(text = "Register",
                    androidx.compose.ui.Modifier.padding(10.dp), fontSize = 20.sp, fontWeight = FontWeight.Normal, color = Color.Black)
            }

            TextButton(onClick = { color = Color.Gray
                navController.navigate(Routes.SignIn.route)}, modifier = Modifier ) {
                Text(text = "Login",modifier = androidx.compose.ui.Modifier
                    .padding(10.dp)
                    .padding(horizontal = 20.dp), fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
            }

        }
    }


    @Composable
    fun StartText(text: String, color: Color, fontSize: Int, fontWeight: FontWeight){
        Text(text = text, color = color, style = TextStyle(
            fontSize = fontSize.sp,
            fontWeight = fontWeight,
        )
        )
    }


    @Composable
    fun Cardview(painter: Painter){
        Card(modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.45f)
            .padding(horizontal = 10.dp)
            .padding(vertical = 15.dp), elevation = 5.dp,
            shape = RoundedCornerShape(20.dp)
        ){
            Column(modifier = androidx.compose.ui.Modifier
                .fillMaxSize()
                .padding(10.dp)){
                Image(painter = painter, contentDescription = "Image",
                    contentScale = ContentScale.Fit,
                    modifier = androidx.compose.ui.Modifier
                        .fillMaxHeight()
                        .fillMaxWidth())
            }
        }

    }

    @Composable
    fun ColumnAppTitle(){
        Column(modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)) {
            Column(modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .padding(vertical = 30.dp)
                , verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                StartText(text = "Discover your", color = Color.Black, fontSize = 30, fontWeight = FontWeight.Bold)
                StartText(text = "Pros and Cons here", color = Color.Black, fontSize = 30, fontWeight = FontWeight.Bold)
            }

            Column(modifier = androidx.compose.ui.Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                StartText(text = "Supervise your work progress", color = Color.Black, fontSize = 20, fontWeight = FontWeight.Normal)
                StartText(text = "with the best software", color = Color.Black, fontSize = 20, fontWeight = FontWeight.Normal)
            }
        }
    }




}
@Preview(showBackground = true)
@Composable
fun  Preview(){
}