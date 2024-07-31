package com.example.service;

import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.entity.JournalEntry;
import com.example.repository.JournalEntryRepo;


@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;


    public void SaveEntry(JournalEntry journalEntry){ 
            journalEntryRepo.save( journalEntry);
        }
    

    public List<JournalEntry>ShowEntry(){                
        return journalEntryRepo.findAll();
    }

    public void DeleteAll(){                         
        journalEntryRepo.deleteAll();
    }

   public Optional<JournalEntry>findById(ObjectId MyId){ 
    return journalEntryRepo.findById(MyId);
   }

   public void deletebyid(ObjectId MyId){                
     journalEntryRepo.deleteById(MyId);

   }
 
}
