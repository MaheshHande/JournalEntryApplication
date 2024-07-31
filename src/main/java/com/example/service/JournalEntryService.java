package com.example.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.entity.JournalEntry;
import com.example.repository.JournalEntryRepo;


@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;


    public void SaveEntry(JournalEntry journalEntry){ 
            journalEntryRepo.save( journalEntry);
        }
    

    public List<JournalEntry>ShowEntry(){                // Test Done (ShowEntry)
        return journalEntryRepo.findAll();
    }

    public void DeleteAll(){                            // Test Done (Delete All)
        journalEntryRepo.deleteAll();
    }

   public Optional<JournalEntry>findById(ObjectId MyId){ // Test Done (Find By ID)
    return journalEntryRepo.findById(MyId);
   }

   public void deletebyid(ObjectId MyId){                // Test Done (Delete By ID)
     journalEntryRepo.deleteById(MyId);

   }

   public JournalEntry updateEntryById(@PathVariable ObjectId MyId, @RequestBody JournalEntry UpdatedEntry){
    JournalEntry oldEntry = journalEntryRepo.findById(MyId).orElse(null);
    if(oldEntry!=null){
     oldEntry.setTitle(UpdatedEntry.getTitle() != null && UpdatedEntry.getTitle().equals("")?UpdatedEntry.getTitle() : oldEntry.getTitle());
     oldEntry.setContent(UpdatedEntry.getContent() != null && UpdatedEntry.equals("")?UpdatedEntry.getContent():oldEntry.getContent());
    }
    journalEntryRepo.save(oldEntry);
     return oldEntry;
    
   }
 
}
