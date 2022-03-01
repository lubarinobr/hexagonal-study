package com.chrono.whattoeat.domain

import org.hibernate.annotations.GenericGenerator
import javax.persistence.CascadeType
import javax.persistence.Id
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity(name = "Recipe")
@Table(name = "recipe")
data class Recipe(
    @Id
    @GeneratedValue(
        strategy = GenerationType.AUTO,
        generator = "native"
    )
    @GenericGenerator(
        name = "native",
        strategy = "native"
    )
    val id: Long? = null,
    val name: String,
    @OneToMany(
        mappedBy = "recipe",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    val recipeProducts: MutableList<RecipeProduct> = mutableListOf()
) {

    fun addProducts(product: Product, unit: Unit, quantity: Double) {
        val recipeProduct = RecipeProduct(recipe = this, product = product, unit = unit, quantity = quantity)
        this.recipeProducts.add(recipeProduct)
    }
}
