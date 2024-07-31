package com.example.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.JournalEntry;
import com.example.service.JournalEntryService;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
     
    @Autowired
    private JournalEntryService journalEntryService;
   


          // Geting The All Entries 
    @GetMapping("/getall")
    public List<JournalEntry> getall(){
      return journalEntryService.ShowEntry();
   }

         // Creating The Journal Entry 
    @PostMapping("/createEntry")
    public JournalEntry  createEntry(@RequestBody JournalEntry MyEntry){
         journalEntryService.SaveEntry(MyEntry);
         return MyEntry;
    }

 
         // Finding The Journal Entry By Id
    @GetMapping("/getbyid/{MyId}")
    public JournalEntry getbyid(@PathVariable ObjectId MyId){
         return journalEntryService.findById(MyId).orElse(null);
     
    }

         // Deleting The Entry By Id
    @DeleteMapping("/deletebyid/{MyId}")
    public String deleteEnteryById(@PathVariable ObjectId MyId){
         journalEntryService.deletebyid(MyId);
         return "Journal Entry Deleted Successfully ";
    }

          // Delete All Entries 
   @DeleteMapping("/deleteall")
   public String deleteall(){
         journalEntryService.DeleteAll();
         return "All Entries Deleted Sucessfully";
 } 

     
    @PutMapping("/update/{id}")
    public JournalEntry updateEntryById(@PathVariable ObjectId MyId, @RequestBody JournalEntry UpdatedEntry){
      journalEntryService.updateEntryById(MyId, UpdatedEntry);
      return UpdatedEntry;
}

}