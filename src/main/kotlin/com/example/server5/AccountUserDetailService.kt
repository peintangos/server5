package com.example.server5

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.math.acos

@Service
class AccountUserDetailService:UserDetailsService {
    @Autowired
    lateinit var accountRepository: AccountRepository

    @Transactional(readOnly = true)
    override fun loadUserByUsername(username: String?): UserDetails {
        var account = accountRepository.findByName(username!!)
        if (account == null){
            throw UsernameNotFoundException("レコードが見つかりません。")
        }
        if (account.role == "ROLE_USER"){
            return AccountUserDetails(account,AuthorityUtils.createAuthorityList("ROLE_USER"))
        }else {
            return AccountUserDetails(account,AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_ADMIN"))
        }
    }
}