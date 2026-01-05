package com.olvera.fitness.infrastructure.adapter.output.persistence.repository

import com.olvera.fitness.infrastructure.adapter.output.persistence.entity.UserJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface SpringDataJpaUserRepository : JpaRepository<UserJpaEntity, UUID> {

    fun findByEmail(email: String): Optional<UserJpaEntity>

    fun existsByEmail(email: String): Boolean

}