package com.example.server5

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository:CrudRepository<UserDao,String> {
    fun findByName(name:String):UserDao?
}