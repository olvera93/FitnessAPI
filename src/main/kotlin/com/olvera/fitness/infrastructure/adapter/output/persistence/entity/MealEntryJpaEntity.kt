package com.olvera.fitness.infrastructure.adapter.output.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "meals")
data class MealEntryJpaEntity(

    @Id
    val id: UUID,

    @Column(nullable = false)
    val userId: UUID,

    @Column(nullable = false)
    val entryTime: LocalDateTime,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val totalCalories: Int,

    @Column(nullable = false)
    val proteinGrams: Int,

    @Column(nullable = false)
    val fatGrams: Int,

    @Column(nullable = false)
    val carbGrams: Int,

    @Column(nullable = true)
    val imageUrl: String?,
) {

    protected constructor() : this(
        id = UUID.randomUUID(),
        userId = UUID.randomUUID(),
        entryTime = LocalDateTime.now(),
        name = "",
        totalCalories = 0,
        proteinGrams = 0,
        fatGrams = 0,
        carbGrams = 0,
        imageUrl = null,
    )
}
