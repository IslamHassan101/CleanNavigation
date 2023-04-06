package com.islam.cleannavigation.users

data class UsersViewState(
    val users: List<User> = listOf(
        User("Firstname1", "lastname1"),
        User("Firstname2", "lastname2"),
        User("Firstname3", "lastname3"),
        User("Firstname4", "lastname4"),
        User("Firstname5", "lastname5")
    )
)


data class User(val firstName: String, val lastName: String)