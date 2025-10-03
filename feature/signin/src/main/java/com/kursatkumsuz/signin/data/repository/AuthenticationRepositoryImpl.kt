package com.kursatkumsuz.signin.data.repository

import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.kursatkumsuz.domain.model.User
import com.kursatkumsuz.signin.domain.repository.AuthenticationRepository
import kotlinx.coroutines.delay

class AuthenticationRepositoryImpl(
    private val firebaseAuth: FirebaseAuth
    ) : AuthenticationRepository {
    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): Task<User> {
        delay(1000)
       // return firebaseAuth.signInWithEmailAndPassword(email, password)
        return Tasks.forResult(User(name = "Thai Nguyen", email = email) )
    }
}