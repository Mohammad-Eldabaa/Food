package com.example.food.Code_items

data class KindOfFood(val strMeal:String,
                      val strMealThumb:String,
                      val idMeal:String)

data class ListKindOfFood(val meals: List<KindOfFood>)
