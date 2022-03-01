package com.chrono.whattoeat.repository

import com.chrono.whattoeat.domain.Recipe
import org.springframework.data.jpa.repository.JpaRepository

interface RecipeRepository : JpaRepository<Recipe, Long>
