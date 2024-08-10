package com.example.food.Code_items

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.food.TheKind
import kotlinx.coroutines.launch

class ViewModelItem( ):ViewModel() {


    private val _categoryItemState = mutableStateOf(RecipeItemState())
    val categoriesItemState: State<RecipeItemState> = _categoryItemState



    init {
        _fetchingItemCategories()
        Log.i("55555555555555555555", categoriesItemState.toString())


    }

    private fun _fetchingItemCategories(){
        viewModelScope.launch {

            try {

                val response2 = api_item(TheKind.Kind)
                if (response2 != null) {
                    Log.i("dddddddddddddddd999", response2.meals.toString())




                    _categoryItemState.value = _categoryItemState.value.copy(
                        list = response2.meals,
                        error = null,
                        loading = false
                    )}
                    Log.i("dddddddddddddd1", _categoryItemState.value.loading.toString() )



            }catch (e: Exception){
                _categoryItemState.value = _categoryItemState.value.copy(
                    error = "Error fetching Categories ${e.message}",
                    loading = false
                )
                Log.i("dddddddddddddd2", "_fetchingItemCategories: ")

            }

        }

    }

    data class RecipeItemState(
        val loading: Boolean = true,
        val error: String? = null,
        val list:List<KindOfFood> = emptyList()
    )




}