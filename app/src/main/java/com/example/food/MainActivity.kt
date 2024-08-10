package com.example.food

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.food.Code_Main_interface.Food
import com.example.food.Code_Main_interface.designe.userInterface
import com.example.food.Code_Main_interface.recipeMealService
//import com.example.food.Code_items.api_item
import com.example.food.Code_items.designe.ItemShow
import com.example.food.Meal.MealShow
import com.example.food.ui.theme.FoodTheme
import com.example.food.ui.theme.mainFlash
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodTheme {
                Surface(modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp)) {

                    mainFlash()
                }
            }
        }
    }
}



@Composable
fun navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController ,startDestination = "firstscreen") {

        composable("firstscreen") {
            userInterface {str->
                navController.navigate("secondscreen/$str")
            }
        }

        composable("secondscreen/{str}"){
            val str = it.arguments?.getString("str") ?: "nothing"
            ItemShow(str = str){
                navController.navigate("thirdscreen/$str")
            }
        }

        composable("thirdscreen/{str}"){
            val str = it.arguments?.getString("str") ?: "Arrabiata"
            Log.i("strrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr",str)
            MealShow(str )
        }

    }

}






@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodTheme {
    }
}