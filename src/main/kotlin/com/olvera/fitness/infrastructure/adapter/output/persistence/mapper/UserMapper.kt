package com.olvera.fitness.infrastructure.adapter.output.persistence.mapper

import com.olvera.fitness.domain.model.*
import com.olvera.fitness.infrastructure.adapter.output.persistence.entity.UserJpaEntity

fun UserJpaEntity.toDomain(): User {
    return User(
        id = UserId(this.id),
        email = this.email,
        passwordHash = this.passwordHash,
        role = UserRole.valueOf(this.role),
        name = this.name,
        gender = Gender.valueOf(this.gender),
        dateOfBirth = this.dateOfBirth,
        heightCm = this.heightCm,
        weightKg = this.weightKg,
        activityLevel = ActivityLevel.valueOf(this.activityLevel)
    )
}

fun User.toJpaEntity(): UserJpaEntity {
    return UserJpaEntity(
        id = this.id.value,
        email = this.email,
        passwordHash = this.passwordHash,
        role = this.role.name,
        name = this.name,
        gender = this.gender.name,
        dateOfBirth = this.dateOfBirth,
        heightCm = this.heightCm,
        weightKg = this.weightKg,
        activityLevel = this.activityLevel.name
    )
}