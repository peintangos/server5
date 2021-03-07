package com.example.server5

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AccountUserDetails:UserDetails {

    private lateinit var userDao:UserDao
    private lateinit var authorities:Collection<GrantedAuthority>
    constructor(userDao:UserDao,authorities:Collection<GrantedAuthority>){
        this.authorities = authorities
        this.userDao = userDao
    }

    override fun getAuthorities(): Collection<GrantedAuthority> {
        return authorities
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUsername(): String {
        return userDao.name
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return userDao.pass
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }
}