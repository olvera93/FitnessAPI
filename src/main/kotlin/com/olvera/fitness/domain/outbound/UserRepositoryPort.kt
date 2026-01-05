package com.olvera.fitness.domain.outbound

import com.olvera.fitness.domain.model.User

interface UserRepositoryPort {

    fun save(user: User): User

}