package com.example.food.Meal

import Meal
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.food.Code_items.ViewModelItem
import com.example.food.Code_items.designe.body2
import com.example.food.TheKind

@Composable
fun MealShow(meal_name : String) {


    val recipeMealVM: ViewModelMeal = viewModel()
    val view_state_Item by recipeMealVM.mealState

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 32.dp)) {


        when {
            view_state_Item.loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            view_state_Item.error != null -> {
                Text(
                    text = "No internet connection",
                    modifier = Modifier,
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp
                )
            }

            else -> {
                body3(meal = view_state_Item.list[0])
            }

        }
    }
}

@Composable
fun body3(meal:Meal) {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .verticalScroll(rememberScrollState())) {

    Text(text = meal.strMeal,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        textAlign = TextAlign.Center, fontSize = 28.sp,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.height(8.dp))


        Text(text = meal.strCategory, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, style = MaterialTheme.typography.bodyLarge)
        Text(text = meal.strArea, modifier = Modifier.fillMaxWidth(),  textAlign = TextAlign.Center, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(16.dp))


        Image(
            painter = rememberAsyncImagePainter(model = meal.strMealThumb),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Component:", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))

        component(1,ingredient = meal.strIngredient1, measure =meal.strMeasure1 )
        component(2,ingredient = meal.strIngredient2, measure =meal.strMeasure2 )
        component(3,ingredient = meal.strIngredient3, measure =meal.strMeasure3 )
        component(4,ingredient = meal.strIngredient4, measure =meal.strMeasure4 )
        component(5,ingredient = meal.strIngredient5, measure =meal.strMeasure5 )
        component(6,ingredient = meal.strIngredient6, measure =meal.strMeasure6 )
        component(7,ingredient = meal.strIngredient7, measure =meal.strMeasure7 )
        component(8,ingredient = meal.strIngredient8, measure =meal.strMeasure8 )
        component(9,ingredient = meal.strIngredient9, measure =meal.strMeasure9 )
        component(10,ingredient = meal.strIngredient10, measure =meal.strMeasure10 )
        component(11,ingredient = meal.strIngredient11, measure =meal.strMeasure11 )
        component(12,ingredient = meal.strIngredient12, measure =meal.strMeasure12 )
        component(13,ingredient = meal.strIngredient13, measure =meal.strMeasure13 )
        component(14,ingredient = meal.strIngredient14, measure =meal.strMeasure14 )
        component(15,ingredient = meal.strIngredient15, measure =meal.strMeasure15 )
        component(16,ingredient = meal.strIngredient16, measure =meal.strMeasure16 )
        component(17,ingredient = meal.strIngredient17, measure =meal.strMeasure17 )
        component(18,ingredient = meal.strIngredient18, measure =meal.strMeasure18 )
        component(19,ingredient = meal.strIngredient19, measure =meal.strMeasure19 )
        component(10,ingredient = meal.strIngredient20, measure =meal.strMeasure20 )


        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Instructions:", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = meal.strInstructions.replace("\n","\n\n"), modifier = Modifier.fillMaxSize(), color = Color.Black, fontSize = 16.sp)

    }
}



@Composable
fun component(num:Int = 1,ingredient:String?,measure:String?){

    val compon= remember {
        mutableStateOf("$num. ${ingredient} - ${measure}")
    }

    if(ingredient!="" && measure != null){ Text(text = compon.value)  }

}




