package com.example.soccerbaseapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Player {
    @Id
    private String id;
    private String name;
    private String birthDate;
    private int height;
    private String foot;
    private String countryId;
    private String currentTeamId;

    public Player(String id, String name, String birthDate, int height, String foot, String countryId, String currentTeamId) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.height = height;
        this.foot = foot;
        this.countryId = countryId;
        this.currentTeamId = currentTeamId;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCurrentTeamId() {
        return currentTeamId;
    }

    public void setCurrentTeamId(String currentTeamId) {
        this.currentTeamId = currentTeamId;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", height=" + height +
                ", foot='" + foot + '\'' +
                ", countryId='" + countryId + '\'' +
                ", currentTeamId='" + currentTeamId + '\'' +
                '}';
    }
}
