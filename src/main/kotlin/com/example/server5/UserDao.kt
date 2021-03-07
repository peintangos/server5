package com.example.server5

import org.springframework.data.relational.core.mapping.Table

@Table("User")
data class UserDao(val id:Int,val name:String,val pass:String,val role:String) {

}