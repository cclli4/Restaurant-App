package com.example.restaurantsapp

import androidx.room.*
import com.example.restaurantapp.Restaurant

@Dao
interface RestaurantsDao {

    // Retrieve all restaurants
    @Query("SELECT * FROM restaurants")
    fun getAll(): List<Restaurant>

    // Insert a list of restaurants and replace any with the same ID
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(restaurants: List<Restaurant>)

    // Update a specific field(s) in a single restaurant using PartialRestaurant
    @Update(entity = Restaurant::class)
    fun update(partialRestaurant: PartialRestaurant)

    // Update specific fields in multiple restaurants
    @Update(entity = Restaurant::class)
    fun updateAll(partialRestaurants: List<PartialRestaurant>)

    // Retrieve only favorited restaurants
    @Query("SELECT * FROM restaurants WHERE is_favorite = 1")
    fun getAllFavorited(): List<Restaurant>
}
