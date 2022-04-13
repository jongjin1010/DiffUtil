package com.jjoh.diffutil

data class Human(
    val name: String,
    val age: Int,
    val sex: String,
    val job: Job
)

enum class Job {
    Student, Teacher, Developer
}
