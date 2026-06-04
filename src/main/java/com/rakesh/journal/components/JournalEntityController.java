package com.rakesh.journal.components;

import com.rakesh.journal.entity.JournalEntity;
import com.rakesh.journal.services.JournalEntityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/journal")
public class JournalEntityController {
    private JournalEntityService journalEntityService;
//    public JournalEntityController(JournalEntity journalEntity){
//        this.journalEntity = journalEntity;
//    }
    public JournalEntityController(JournalEntityService journalEntityService){
        this.journalEntityService = journalEntityService;
    }

    @GetMapping("/getAll")
    public List<JournalEntity> getJournalEntity(){
        return journalEntityService.getJournal();
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<JournalEntity>> getJournalEntityByUsername(@PathVariable String username){
        List<JournalEntity> list = journalEntityService.getByUsername(username);
        if(list == null) return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/{username}")
    public ResponseEntity<JournalEntity> setJournalEntity(@RequestBody JournalEntity journalEntity, @PathVariable String username){

        JournalEntity journalEntity1 = journalEntityService.saveJournal(journalEntity, username);
        if(journalEntity1 == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(journalEntity1, HttpStatus.CREATED);
    }

    @DeleteMapping("/{username}/{id}")
    public ResponseEntity<JournalEntity> getJournalEntity(@PathVariable String username, @PathVariable String id){
        JournalEntity journalEntity = journalEntityService.deleteJournal(id, username);
        if(journalEntity == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(journalEntity, HttpStatus.OK);
    }
}
