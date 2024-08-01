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
   


        // Creating The Journal Entry 
        @PostMapping("/createEntry")
        public JournalEntry  createEntry(@RequestBody JournalEntry MyEntry){
             journalEntryService.SaveEntry(MyEntry);
             return MyEntry;
        }
    

          // Geting The All Entries 
    @GetMapping("/getall")
    public List<JournalEntry> getall(){
      return journalEntryService.ShowEntry();
   }

 
         // Finding The Journal Entry By Id
    @GetMapping("/getbyid/{MyId}")
    public JournalEntry getbyid(@PathVariable ObjectId MyId){
         return journalEntryService.findById(MyId).orElse(null);
     
    }

         // Deleting The Entry By Id
    @DeleteMapping("/deletebyid/{MyId}")
    public boolean deleteEnteryById(@PathVariable ObjectId MyId){
         journalEntryService.deletebyid(MyId);
        return true;
    }

          // Delete All Entries 
   @DeleteMapping("/deleteall")
   public String deleteall(){
         journalEntryService.DeleteAll();
         return "All Entries Deleted Sucessfully";
 } 

     // Update Journal Entry By id
    @PutMapping("/update/{MyId}")
    public JournalEntry updateEntryById(@PathVariable ObjectId MyId, @RequestBody JournalEntry UpdatedEntry){
    JournalEntry old= journalEntryService.findById(MyId).orElse(null);
    if(old != null){
     old.setTitle(UpdatedEntry.getTitle() != null && !UpdatedEntry.getTitle().equals("")?UpdatedEntry.getTitle():old.getTitle());
    old.setContent(UpdatedEntry.getContent() !=null && !UpdatedEntry.equals("")?UpdatedEntry.getContent():old.getContent());
}
     journalEntryService.SaveEntry(old);
      return UpdatedEntry;
}

}