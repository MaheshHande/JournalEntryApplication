package com.example.entity;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Document
@Data
public class JournalEntry {
  
    @Id
    private ObjectId id;
    @NonNull
    private String title;

    private String content;

}

