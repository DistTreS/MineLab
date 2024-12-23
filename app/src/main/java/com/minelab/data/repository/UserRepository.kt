package com.minelab.data.repository

import com.minelab.data.dao.UserDao
import com.minelab.data.entity.User

class UserRepository(private val userDao: UserDao) {
    suspend fun getUserByEmail(email: String): User? {
        return userDao.getUserByEmail(email)
    }
}
