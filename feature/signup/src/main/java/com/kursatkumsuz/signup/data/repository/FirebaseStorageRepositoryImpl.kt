package com.kursatkumsuz.signup.data.repository

import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.kursatkumsuz.domain.model.User
import com.kursatkumsuz.signup.domain.repository.FirebaseStorageRepository
import com.kursatkumsuz.util.Constants.USER_COLLECTION
import kotlinx.coroutines.delay

class FirebaseStorageRepositoryImpl(
    private val firebaseFirestore: FirebaseFirestore,
) : FirebaseStorageRepository {
    override suspend fun saveUser(
        userUid: String,
        user: User
    ): Task<User> {
        delay(1000)
        //return firebaseFirestore.collection(USER_COLLECTION).document(userUid).collection("info").add(user)
        return Tasks.forResult(user)
    }
}