package Navigation

sealed class Routes(val route: String){
    object StartScreen: Routes("startScreen")
    object SignUp: Routes("signUp")
    object SignIn: Routes("signIn")
    object Alternative: Routes("Alternative")
    object NumberAuthentication: Routes("Nauth")
}
