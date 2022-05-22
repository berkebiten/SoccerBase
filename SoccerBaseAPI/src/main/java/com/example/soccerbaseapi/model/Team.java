package com.example.soccerbaseapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Team {
    @Id
    private String id;
    private String name;
    private String leagueId;
    private String countryId;
    private String logoName;

    public Team(String id, String name,
                String leagueId, String countryId,
                String logoName) {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
        this.leagueId = leagueId;
        this.logoName = logoName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getLogoName() {
        return logoName;
    }

    public void setLogoName(String logoName) {
        this.logoName = logoName;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", leagueId='" + leagueId + '\'' +
                ", countryId='" + countryId + '\'' +
                ", logoName='" + logoName + '\'' +
                '}';
    }
}
