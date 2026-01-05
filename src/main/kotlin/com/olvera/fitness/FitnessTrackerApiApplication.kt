package com.olvera.fitness

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FitnessTrackerApiApplication

fun main(args: Array<String>) {
	runApplication<FitnessTrackerApiApplication>(*args)
}