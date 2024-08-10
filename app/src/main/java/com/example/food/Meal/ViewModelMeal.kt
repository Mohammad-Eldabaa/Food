package com.example.food.Meal

import Meal
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.food.Code_Main_interface.recipeMealService
import com.example.food.TheKind
import kotlinx.coroutines.launch

class ViewModelMeal(): ViewModel() {
    private val _mealState = mutableStateOf(RecipeMealState())
    val mealState = _mealState

    init {
        _fetchingMeal()
    }

    private fun _fetchingMeal(){

        viewModelScope.launch {
            try {
                val response = recipeMealService.getComponents(search = TheKind.Meal_Name)

                Log.i("ResponseMealisrunnnnnnnnnnnnnn", response.toString())

                _mealState.value = _mealState.value.copy(
                    list = response.meals,
                    error = null,
                    loading = false
                )
            } catch (e: Exception) {
                _mealState.value = _mealState.value.copy(
                    error = "Error fetching Categories ${e.message}",
                    loading = false
                )

            }
        }
    }






    data class RecipeMealState(
        val loading: Boolean = true,
        val error: String? = null,
        val list: List<Meal> = emptyList()

    )
}

