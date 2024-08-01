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

    // Get All Entries 
    public List<JournalEntry>ShowEntry(){                
        return journalEntryRepo.findAll();
    }

    // Save The Entries
    public void SaveEntry(JournalEntry journalEntry){ 
            journalEntryRepo.save( journalEntry);
        }
    
    // Delete All Entries 
    public void DeleteAll(){                         
        journalEntryRepo.deleteAll();
    }

    //  Find Entries By Id
   public Optional<JournalEntry>findById(ObjectId MyId){ 
    return journalEntryRepo.findById(MyId);
   }

   // Delete Entries By Id
   public void deletebyid(ObjectId MyId){                
     journalEntryRepo.deleteById(MyId);

   }
 
}
