package com.example.food.Code_items.designe

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.food.Code_Main_interface.Food
import com.example.food.Code_items.KindOfFood
import com.example.food.Code_items.ViewModelItem
import com.example.food.TheKind

@Composable
fun ItemShow(str:String ,onclickMeal:() -> Unit = {}){

    TheKind.Kind = str


//    val recipeItemVM : ViewModelItem = ViewModelItem(str)
//    val view_state_Item by recipeItemVM.categoriesItemState
    val recipeItemVM:ViewModelItem = viewModel()
    val view_state_Item by recipeItemVM.categoriesItemState
    Log.i("55555555555555555555", view_state_Item.toString())



    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 32.dp)) {
//        Log.i("dddddddddddddd666", view_state_Item.list.toString())
        Log.i("22222222222222222", view_state_Item.loading.toString())
        Log.i("22222222222222222", view_state_Item.error.toString())
        Log.i("22222222222222222", view_state_Item.list.toString())


        when{
            view_state_Item.loading-> {
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
//                Log.i("dddddddddddddddd", view_state_Item.error!!)
            }

            else->{
                body2(str,categories = view_state_Item.list,onclickMeal = onclickMeal)
            }

        }
    }



}


@Composable
fun body2(str:String,categories: List<KindOfFood>,onclickMeal:() -> Unit = {}){
    Column(modifier = Modifier.fillMaxSize()){

        Text(text = str,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            color = Color.Gray,
            textAlign = TextAlign.Center, fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )




        LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
        items(categories){cat ->
           item2(name = cat,onclickMeal = onclickMeal)
        }
    }
}
}


@Composable
fun item2(name: KindOfFood,onclickMeal:() -> Unit = {}){




    Column(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier
        .padding(8.dp)
        .clickable { onclickMeal(); TheKind.Meal_Name = name.strMeal }
        .fillMaxSize()
        .fillMaxSize()
        .padding(8.dp)) {
        Image(
            painter = rememberAsyncImagePainter(model = name.strMealThumb),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )

        Text(
            text = name.strMeal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 4.dp)
                .fillMaxWidth(),
            style = TextStyle(fontWeight = FontWeight.Bold),
            color = Color.Black
        )

    }

}



