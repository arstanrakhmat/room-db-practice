package com.example.roomdatabasepractice.data

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {

    val allUsers: Flow<List<User>> = userDao.readAllData()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }
}