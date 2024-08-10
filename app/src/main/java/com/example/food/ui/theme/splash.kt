package com.example.food.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.food.MainActivity
import com.example.food.R
import com.example.food.navigation
import kotlinx.coroutines.delay

@Composable
fun MyAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(),
        typography = Typography,
        content = content
    )
}



@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White), // Background color
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(text = "Food App",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                ,fontSize = 55.sp
                , fontWeight = FontWeight.Bold
                , color = Color.Gray)
            Image(
                painter = painterResource(id = R.drawable.inro),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(50.dp)
                    .aspectRatio(1f)
            )
        }

    }
}


@Composable
fun mainFlash(){
//    installSplashScreen()

        MyAppTheme {
            // Splash screen composable
            var isSplashScreenVisible by remember { mutableStateOf(true) }

            LaunchedEffect(key1 = true) {
                delay(2000) // Duration of the splash screen
                isSplashScreenVisible = false
            }

            if (isSplashScreenVisible) {
                SplashScreen()
            } else {
                navigation()
            }
        }
    }



