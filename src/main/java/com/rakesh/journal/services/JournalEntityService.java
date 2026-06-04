package com.rakesh.journal.services;

import com.rakesh.journal.entity.JournalEntity;
import com.rakesh.journal.entity.UserEntity;
import com.rakesh.journal.repository.JournalEntityRepository;
import com.rakesh.journal.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JournalEntityService {
    private JournalEntityRepository journalEntityRepository;
    private UserEntityRepository userEntityRepository;
    public JournalEntityService(JournalEntityRepository journalEntityRepository, UserEntityRepository userEntityRepository){
        this.journalEntityRepository = journalEntityRepository;
        this.userEntityRepository = userEntityRepository;
    }

    public JournalEntity saveJournal(JournalEntity journalEntity, String username){
        UserEntity user = userEntityRepository.findByUsername(username);
        if(user == null){
            return null;
        }
        JournalEntity journalEntity1 = journalEntityRepository.save(journalEntity);
        user.getJournalRef().add(journalEntity1.getId());
        userEntityRepository.save(user);
        return journalEntity1;
    }

    public List<JournalEntity> getByUsername(String username){
        UserEntity userEntity = userEntityRepository.findByUsername(username);
        if(userEntity == null) return null;
        List<JournalEntity> list = new ArrayList<>();
        userEntity.getJournalRef().forEach(id -> list.add(journalEntityRepository.findById(id).orElse(null)));
        return list;
    }

    public List<JournalEntity> getJournal(){
        return journalEntityRepository.findAll();
    }

    public JournalEntity deleteJournal(String id, String username){
        Optional<JournalEntity> journalEntity = journalEntityRepository.findById(id);
        UserEntity userEntity = userEntityRepository.findByUsername(username);
        userEntity.getJournalRef().remove(id);
        userEntityRepository.save(userEntity);
        if(journalEntity.isEmpty()){
            return null;
        }
        return journalEntity.orElse(null);
    }
}
