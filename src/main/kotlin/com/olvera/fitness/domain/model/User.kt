package com.olvera.fitness.domain.model

import java.math.BigDecimal
import java.time.LocalDate
import java.time.Period
import java.util.UUID

@JvmInline
value class UserId(val value: UUID)

enum class UserRole { USER, COACH }
enum class Gender { MALE, FEMALE }
enum class ActivityLevel { SEDENTARY, LIGHT, MODERATE, HIGH, VERY_HIGH }

data class User(
    val id: UserId = UserId(UUID.randomUUID()),
    val email: String,
    val passwordHash: String,
    val role: UserRole,

    val name: String,
    val gender: Gender,
    val dateOfBirth: LocalDate,
    val heightCm: Int,
    var weightKg: BigDecimal,
    val activityLevel: ActivityLevel
) {

    fun calculateAge(currentDate: LocalDate = LocalDate.now()): Int {
        return Period.between(dateOfBirth, currentDate).years
    }

}
