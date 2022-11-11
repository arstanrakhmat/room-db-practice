package com.example.roomdatabasepractice.data

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class UserViewModel(private val userDao: UserDao) : ViewModel() {

    val allWords: LiveData<List<User>> = userDao.readAllData().asLiveData()

    fun addUser(user: User) = viewModelScope.launch {
        userDao.addUser(user)
    }
}

class UserViewModelFactory(private val userDao: UserDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(userDao) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}