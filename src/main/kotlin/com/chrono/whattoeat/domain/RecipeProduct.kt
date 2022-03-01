package com.chrono.whattoeat.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.MapsId
import javax.persistence.Table

@Embeddable
class RecipeProductId(
    @Column(name = "recipe_id")
    val recipeId: Long? = null,
    @Column(name = "product_id")
    val productId: Long? = null
): Serializable

@Entity(name = "RecipeProduct")
@Table(name = "recipe_product")
class RecipeProduct(
    @EmbeddedId
    val id: RecipeProductId? = RecipeProductId(),
    @Enumerated(EnumType.STRING)
    val unit: Unit,
    val quantity: Double,
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("recipeId")
    @JsonIgnore
    val recipe: Recipe,
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    val product: Product
)
