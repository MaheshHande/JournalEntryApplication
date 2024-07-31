package com.example.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.entity.JournalEntry;

public interface JournalEntryRepo extends MongoRepository<JournalEntry,ObjectId>{


}

