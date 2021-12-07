package com.chrono.whattoeat.foods

import com.chrono.whattoeat.foods.RecipeFixtures.recipesWeek
import com.chrono.whattoeat.foods.domain.ports.RecipeRepository
import com.chrono.whattoeat.foods.domain.ports.RecipeService
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import reactor.test.StepVerifier

@ExtendWith(SpringExtension::class)
@ActiveProfiles("test")
class FoodServiceTest {

    @InjectMocks
    private lateinit var recipeService: RecipeService
    @Mock
    private lateinit var recipeRepository: RecipeRepository

    @Test
    fun whenRetrievingRandomsFoodsThenReturnListWithSixFoods() {
        Mockito.`when`(recipeRepository.getRandomsFoods()).thenReturn(recipesWeek())
        val list = recipeService.getListWithFoodToTheWeek()
        StepVerifier
            .create(list)
            .expectNextCount(6)
            .verifyComplete()
    }
}