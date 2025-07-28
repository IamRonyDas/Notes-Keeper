package com.kotin_Springboot.kotlin_springboot.database.repository

import com.kotin_Springboot.kotlin_springboot.database.model.Note
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface NoteRepository: MongoRepository<Note, ObjectId> {
    fun findByOwnerId(ownerId: ObjectId): List<Note>
}