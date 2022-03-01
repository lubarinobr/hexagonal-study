package com.chrono.whattoeat.resources

import com.chrono.whattoeat.ServletLocation
import com.chrono.whattoeat.domain.Recipe
import com.chrono.whattoeat.domain.RecipeDTO
import com.chrono.whattoeat.service.RecipeService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/recipes")
class RecipeResource(
    private val recipeService: RecipeService
) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAll(): ResponseEntity<List<Recipe>> {
        val recipes = recipeService.findAll()
        return ResponseEntity.ok(recipes)
    }

    @PostMapping
    fun createRecipe(@RequestBody recipeDTO: RecipeDTO) : ResponseEntity<Void> {
        val id = recipeService.create(recipeDTO)
        val uri = ServletLocation.getUri(id)
        return ResponseEntity.created(uri).build()
    }
}