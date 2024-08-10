package com.example.food.Code_Main_interface

data class Food(
                val idCategory: String,
                val strCategory: String,
                val strCategoryThumb: String,
                val strCategoryDescription: String
            )


data class Food_category_response (val categories: List<Food>)
