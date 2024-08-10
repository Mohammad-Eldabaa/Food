package com.example.food.Code_Main_interface.designe

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.food.Code_Main_interface.Food
import com.example.food.Code_Main_interface.RViewModel
import com.example.food.Code_items.designe.ItemShow

@Composable
fun userInterface(modifier:Modifier = Modifier,movetoSecond:(String)->Unit){
    val recipeVM : RViewModel = viewModel()
    val view_state by recipeVM.categoriesState

    Box(modifier = Modifier.fillMaxSize()){
        when{
            view_state.loading-> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            view_state.error != null -> {
                Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                    Text(
                        text = "No internet connection",
                        modifier = Modifier,
                        color = Color.Red,
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp
                    )
                }
                Log.i("dddddddddddddddd", view_state.error!!)
            }

            else->{
                body(categories = view_state.list,movetoSecond)
            }

        }
    }
}

@Composable
fun body(categories: List<Food>,movetoSecond:(String)->Unit){
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
       items(categories){cat ->
           item(item = cat,movetoSecond)
       }
    }
}


@Composable
fun item(item: Food,onItemClick:(String) -> Unit){
    Column(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier
        .fillMaxSize()
        .fillMaxSize()
        .padding(8.dp)
        .clickable { onItemClick(item.strCategory) }) {
            Image(
                painter = rememberAsyncImagePainter(model = item.strCategoryThumb),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(1f)
                )

            Text(
                text = item.strCategory,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth(),
                style = TextStyle(fontWeight = FontWeight.Bold),
                color = Color.Black
            )

    }

}









//@Preview(showBackground = true)
//@Composable
//fun GreetingjPreview() {
//    userInterface()
//}