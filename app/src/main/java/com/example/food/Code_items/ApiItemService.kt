package com.example.food.Code_items

import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import com.example.food.Code_Main_interface.RViewModel.RecipeState
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
suspend fun api_item(get:String): ListKindOfFood? {
     val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    when(get){
        "Beef" -> {
            val recipeItemService = retrofit.create(ApiItemServiceBeef::class.java)
            return recipeItemService.getItemGategories()

        }
        "Chicken" -> {
            val recipeItemService = retrofit.create(ApiItemServiceChicken::class.java)
            return recipeItemService.getItemGategories()
        }
        "Dessert" -> {
            val recipeItemService = retrofit.create(ApiItemServiceDessert::class.java)
            return recipeItemService.getItemGategories()
        }
        "Lamb" -> {
            val recipeItemService = retrofit.create(ApiItemServiceLamb::class.java)
            return recipeItemService.getItemGategories()
        }
        "Miscellaneous" -> {
            val recipeItemService = retrofit.create(ApiItemServiceMiscellaneous::class.java)
            return recipeItemService.getItemGategories()
        }
        "Pasta" -> {
            val recipeItemService = retrofit.create(ApiItemServicePasta::class.java)
            return recipeItemService.getItemGategories()
        }
        "Pork" -> {
            val recipeItemService = retrofit.create(ApiItemServicePork::class.java)
            return recipeItemService.getItemGategories()
        }
        "Seafood" -> {
            val recipeItemService = retrofit.create(ApiItemServiceSeafood::class.java)
            return recipeItemService.getItemGategories()
        }
        "Side" -> {
            val recipeItemService = retrofit.create(ApiItemServiceSide::class.java)
            return recipeItemService.getItemGategories()
        }
        "Starter" -> {
            val recipeItemService = retrofit.create(ApiItemServiceStarter::class.java)
            return recipeItemService.getItemGategories()
        }
        "Vegan" -> {
            val recipeItemService = retrofit.create(ApiItemServiceVegan::class.java)
            return recipeItemService.getItemGategories()
        }
        "Vegetarian" -> {
            val recipeItemService = retrofit.create(ApiItemServiceVegetarian::class.java)
            return recipeItemService.getItemGategories()
        }
        "Breakfast" -> {
            val recipeItemService = retrofit.create(ApiItemServiceBreakfast::class.java)
            return recipeItemService.getItemGategories()
        }
        "Goat" -> {
            val recipeItemService = retrofit.create(ApiItemServiceGoat::class.java)
            return recipeItemService.getItemGategories()
        }
    }

    return null

}




interface ApiItemServiceBeef {
    @GET("filter.php?c=Beef")
    suspend fun getItemGategories(): ListKindOfFood
}
interface ApiItemServiceChicken {
    @GET("filter.php?c=Chicken")
    suspend fun getItemGategories(): ListKindOfFood
}
interface ApiItemServiceDessert {
    @GET("filter.php?c=Dessert")
    suspend fun getItemGategories(): ListKindOfFood
}
interface ApiItemServiceLamb {
    @GET("filter.php?c=Lamb")
    suspend fun getItemGategories(): ListKindOfFood
}
interface ApiItemServiceMiscellaneous {
    @GET("filter.php?c=Miscellaneous")
    suspend fun getItemGategories(): ListKindOfFood
}
interface ApiItemServicePasta {
    @GET("filter.php?c=Pasta")
    suspend fun getItemGategories(): ListKindOfFood
}
interface ApiItemServicePork {
    @GET("filter.php?c=Pork")
    suspend fun getItemGategories(): ListKindOfFood
}
interface ApiItemServiceSeafood {
    @GET("filter.php?c=Seafood")
    suspend fun getItemGategories(): ListKindOfFood
}
interface ApiItemServiceSide {
    @GET("filter.php?c=Side")
    suspend fun getItemGategories(): ListKindOfFood
}
interface ApiItemServiceStarter {
    @GET("filter.php?c=Starter")
    suspend fun getItemGategories(): ListKindOfFood
}
interface ApiItemServiceVegan {
    @GET("filter.php?c=Vegan")
    suspend fun getItemGategories(): ListKindOfFood
}
interface ApiItemServiceVegetarian {
    @GET("filter.php?c=Vegetarian")
    suspend fun getItemGategories(): ListKindOfFood
}
interface ApiItemServiceBreakfast {
    @GET("filter.php?c=Breakfast")
    suspend fun getItemGategories(): ListKindOfFood
}
interface ApiItemServiceGoat {
    @GET("filter.php?c=Goat")
    suspend fun getItemGategories(): ListKindOfFood
}