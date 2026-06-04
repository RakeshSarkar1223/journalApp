package com.rakesh.journal.repository;


import com.rakesh.journal.entity.JournalEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntityRepository extends MongoRepository<JournalEntity, String> {
//    JournalEntity findByUsername(String username);
}
