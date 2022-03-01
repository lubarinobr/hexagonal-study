package com.chrono.whattoeat.service

import com.chrono.whattoeat.domain.Recipe
import com.chrono.whattoeat.domain.RecipeDTO
import org.springframework.transaction.annotation.Transactional

interface IRecipeService : IAbstractService<Recipe> {
    fun create(recipeDTO: RecipeDTO): Long
}
