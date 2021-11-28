package com.chrono.whattoeat.foods.adapters.recipedb

import com.chrono.whattoeat.foods.domain.model.Recipe
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface IDbRecipeRepository : ReactiveCrudRepository<Recipe, String>