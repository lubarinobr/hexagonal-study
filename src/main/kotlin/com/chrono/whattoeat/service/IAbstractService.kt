package com.chrono.whattoeat.service

interface IAbstractService<E> {

    fun findAll() : List<E>
    fun findById(id: Long) : E
    fun deleteById(id: Long)
}