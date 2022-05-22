package com.example.soccerbaseapi.repository;

import com.example.soccerbaseapi.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends MongoRepository<Team, String> {
}
