package com.example.entity;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class JournalEntry {
  
    @Id
    private ObjectId id;

    private String title;

    private String content;


    public ObjectId getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }   
    public String getContent() {
        return content;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }

}

