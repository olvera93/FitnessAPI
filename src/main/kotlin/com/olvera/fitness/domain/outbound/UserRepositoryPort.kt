package com.olvera.fitness.domain.outbound

import com.olvera.fitness.domain.model.User

interface UserRepositoryPort {

    suspend fun save(user: User): User

    suspend fun findByEmail(email: String): User?

}