package com.example.food.Code_Main_interface

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RViewModel: ViewModel() {
    private val _categoryState = mutableStateOf(RecipeState())
    val categoriesState: State<RecipeState> = _categoryState

    init {
        _fetchingCategories()
    }

    private fun _fetchingCategories(){
            viewModelScope.launch {

                try {
                    val response = recipeService.getCategories()
                    _categoryState.value = _categoryState.value.copy(
                        list = response.categories,
                        error = null,
                        loading = false
                    )
                }catch (e: Exception){
                    _categoryState.value = _categoryState.value.copy(
                        error = "Error fetching Categories ${e.message}",
                        loading = false
                    )
                }

            }

    }

    data class RecipeState(
        val loading: Boolean = true,
        val error: String? = null,
        val list:List<Food> = emptyList()
    )


}