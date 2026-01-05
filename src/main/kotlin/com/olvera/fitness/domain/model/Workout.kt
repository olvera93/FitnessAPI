package com.olvera.fitness.domain.model

import java.util.UUID

@JvmInline
value class WorkoutId(val value: UUID)

data class Workout(
    val id: WorkoutId = WorkoutId(UUID.randomUUID()),
    val userId: UserId,
    val name: String,
    val description: String?,
    val durationMinutes: Int,
    val exercises: List<Exercise>
)

// Sub-entity (Value Object)
data class Exercise(
    val name: String,
    val sets: Int,
    val reps: String,
    val notes: String?
)
