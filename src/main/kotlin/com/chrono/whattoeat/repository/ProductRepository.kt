package com.chrono.whattoeat.repository

import com.chrono.whattoeat.domain.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long>
