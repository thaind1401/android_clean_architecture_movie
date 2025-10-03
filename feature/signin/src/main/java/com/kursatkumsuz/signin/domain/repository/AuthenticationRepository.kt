package com.kursatkumsuz.signin.domain.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.kursatkumsuz.domain.model.User

interface AuthenticationRepository {
    suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): Task<User>
}