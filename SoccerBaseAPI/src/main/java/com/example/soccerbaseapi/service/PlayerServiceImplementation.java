package com.example.soccerbaseapi.service;
import com.example.soccerbaseapi.model.Player;
import com.example.soccerbaseapi.repository.PlayerRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class PlayerServiceImplementation implements PlayerService {
    private final PlayerRepository playerRepository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public PlayerServiceImplementation(PlayerRepository playerRepository, MongoTemplate mongoTemplate) {
        this.playerRepository = playerRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Player> getAll() {
        return new ArrayList<>(playerRepository.findAll());
    }

    @Override
    public Optional<Player> getById(String id) {
        return playerRepository.findById(id);
    }

    public List<Player> getByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(".*"+name+".*"));
        return mongoTemplate.find(query, Player.class);
    }

    public List<Player> getByTeamId(String teamId) {
        ObjectId teamOId = new ObjectId(teamId);
        Query query = new Query();
        query.addCriteria(Criteria.where("currentTeamId").is(teamOId));
        return mongoTemplate.find(query, Player.class);
    }

    public List<Player> getByCountryId(String countryId) {
        ObjectId countryOId = new ObjectId(countryId);
        Query query = new Query();
        query.addCriteria(Criteria.where("countryId").is(countryOId));
        return mongoTemplate.find(query, Player.class);
    }

    public List<Player> getByFilters(String name, Integer minAge, Integer maxAge,
                                     String foot, String countryIds, String teamIds) {
        ArrayList<ObjectId> countryIdList = new ArrayList<>();
        ArrayList<ObjectId> teamIdList = new ArrayList<>();
        if(!countryIds.isBlank()){
            for(String val : countryIds.split(",")){
                countryIdList.add(new ObjectId(val));
            }
        }
        if(!teamIds.isBlank()){
            for(String val : teamIds.split(",")){
                teamIdList.add(new ObjectId(val));
            }
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(".*"+name+".*")
                                    .and("foot").regex(".*"+ foot +".*")
        );
        if(countryIdList.size() > 0){
            query.addCriteria(Criteria.where("countryId").in(countryIdList));
        }
        if(teamIdList.size() > 0){
            query.addCriteria(Criteria.where("currentTeamId").in(teamIdList));
        }
        minAge = minAge != null ? minAge: 0;
        maxAge = maxAge != null ? maxAge: Integer.MAX_VALUE;
        String endDate = simpleDateFormat.format(Date.from(LocalDate.now().minusYears(minAge).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        String startDate = simpleDateFormat.format(Date.from(LocalDate.now().minusYears(maxAge).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        query.addCriteria(Criteria.where("birthDate").gte(startDate).lte(endDate));
        return mongoTemplate.find(query, Player.class);
    }

    @Override
    public Player save(Player player) {
        playerRepository.save(player);
        return player;
    }

    @Override
    public boolean delete(String id) {
        try {
            playerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
