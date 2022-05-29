package com.example.soccerbaseapi.requestModel;

import com.mongodb.lang.Nullable;

public class PlayerRequest {
    private @Nullable String name;
    private @Nullable Integer minAge;
    private @Nullable Integer maxAge;
    private @Nullable String foot;
    private @Nullable String countryIds;
    private @Nullable String teamIds;

    public PlayerRequest(String name, int minAge, int maxAge, String foot, String countryIds, String teamIds) {
        this.name = name;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.foot = foot;
        this.countryIds = countryIds;
        this.teamIds = teamIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinAge() {
        return minAge == null ? 0 : minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge == null ? Integer.MAX_VALUE : maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    public String getCountryIds() {
        return countryIds;
    }

    public void setCountryIds(String countryIds) {
        this.countryIds = countryIds;
    }

    public String getTeamIds() {
        return teamIds;
    }

    public void setTeamIds(String teamIds) {
        this.teamIds = teamIds;
    }
}
