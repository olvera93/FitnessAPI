package com.olvera.fitness.infrastructure.adapter.output.persistence.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID


@Entity
@Table(name = "users")
data class UserJpaEntity(

    @Id
    val id: UUID,

    @Column(unique = true, nullable = false)
    val email: String,

    @Column(nullable = false)
    val passwordHash: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val role: String,

    @Column(nullable = false)
    val name: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val gender: String,

    @Column(nullable = false)
    val dateOfBirth: LocalDate,

    @Column(nullable = false)
    val heightCm: Int,

    @Column(precision = 5, scale = 2, nullable = false)
    val weightKg: BigDecimal,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val activityLevel: String

) {
    protected constructor() : this(
        id = UUID.randomUUID(),
        email = "",
        passwordHash = "",
        role = "",
        name = "",
        gender = "",
        dateOfBirth = LocalDate.now(),
        heightCm = 0,
        weightKg = BigDecimal.ZERO,
        activityLevel = ""
    )
}
