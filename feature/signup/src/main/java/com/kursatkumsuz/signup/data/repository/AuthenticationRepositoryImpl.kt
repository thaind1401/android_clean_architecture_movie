package com.kursatkumsuz.signup.data.repository

import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.google.firebase.auth.FirebaseAuth
import com.kursatkumsuz.domain.model.User
import com.kursatkumsuz.signup.domain.repository.AuthenticationRepository
import kotlinx.coroutines.delay

class AuthenticationRepositoryImpl(
    private val firebaseAuth: FirebaseAuth,
) : AuthenticationRepository {
    override suspend fun getUserUid(): String {
        var uid = ""
        firebaseAuth.currentUser?.uid?.let {
            uid = it
        }
        return uid
    }

    override suspend fun signUpWithEmailAndPassword(
        email: String,
        password: String
    ): Task<User> {
        //return firebaseAuth.createUserWithEmailAndPassword(email, password)
        delay(1000)
        return Tasks.forResult(User(name = "Thai Nguyen", email = email) )
    }


}