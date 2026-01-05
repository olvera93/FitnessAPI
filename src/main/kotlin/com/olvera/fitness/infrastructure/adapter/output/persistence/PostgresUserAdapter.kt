package com.olvera.fitness.infrastructure.adapter.output.persistence

import com.olvera.fitness.domain.model.User
import com.olvera.fitness.domain.outbound.UserRepositoryPort
import com.olvera.fitness.infrastructure.adapter.output.persistence.mapper.toDomain
import com.olvera.fitness.infrastructure.adapter.output.persistence.mapper.toJpaEntity
import com.olvera.fitness.infrastructure.adapter.output.persistence.repository.SpringDataJpaUserRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class PostgresUserAdapter(
    private val jpaRepository: SpringDataJpaUserRepository
) : UserRepositoryPort {

    override suspend fun save(user: User): User = withContext(IO) {
        val entity = user.toJpaEntity()
        jpaRepository.save(entity).toDomain()
    }

    override suspend fun findByEmail(email: String): User? = withContext(IO) {
        jpaRepository.findByEmail(email).getOrNull()?.toDomain()
    }
}