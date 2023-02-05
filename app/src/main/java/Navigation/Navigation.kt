package Navigation
import Screens.StartScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.flimmer.authFeat.signIn.Alternative
import com.example.flimmer.authFeat.signIn.SignIn
import com.example.flimmer.authFeat.signUp.NumberAuthentication
import com.example.flimmer.authFeat.signUp.SignUp

@Composable
fun Navigation(){

    val navController = rememberNavController()
    val routeWithArguments =

    NavHost(navController = navController, startDestination = Routes.StartScreen.route ){
        composable(route = Routes.StartScreen.route){
            StartScreen().StartApp(navController)
        }

        composable(route = "${Routes.SignUp.route}/{argument}",
            arguments = listOf(navArgument(name = "argument"){

            })){it
            it.arguments?.getString("argument")?.let { it1 -> SignUp().SignUpScreen(it1, navController) }
        }
        composable(route = Routes.SignIn.route){
            SignIn().SignInScreen()
        }
        composable(route = Routes.Alternative.route){
            Alternative().AlternativeScreen(navController)
        }
        composable(route = Routes.NumberAuthentication.route){
            NumberAuthentication().NAuthScreen()
        }
    }
}