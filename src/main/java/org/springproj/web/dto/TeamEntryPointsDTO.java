package org.springproj.web.dto;

import org.springproj.model.TeamEntry;

public class TeamEntryPointsDTO {
    private TeamEntry teamEntry;
    int points;
    private DriverEntryPointsDTO firstDriverEntry;
    private DriverEntryPointsDTO secondDriverEntry;

    public TeamEntryPointsDTO(TeamEntry teamEntry, int points, DriverEntryPointsDTO firstDriverEntry, DriverEntryPointsDTO secondDriverEntry ) {
        this.teamEntry = teamEntry;
        this.points = points;
        this.firstDriverEntry = firstDriverEntry;
        this.secondDriverEntry = secondDriverEntry;
    }

    public TeamEntryPointsDTO(TeamEntry teamEntry,DriverEntryPointsDTO firstDriverEntry, DriverEntryPointsDTO secondDriverEntry) {
        this(teamEntry, 0, firstDriverEntry, secondDriverEntry);
    }

    public TeamEntryPointsDTO(TeamEntry teamEntry) {
        this(teamEntry, 0, null, null);
    }

    public TeamEntryPointsDTO() {

    }



    public TeamEntry getTeamEntry() {
        return teamEntry;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        if (points > 0)
            this.points = points;
    }

    public DriverEntryPointsDTO getFirstDriverEntry() {
        return this.firstDriverEntry;
    }

    public DriverEntryPointsDTO getSecondDriverEntry() {
        return this.secondDriverEntry;
    }

    public void setFirstDriverEntry(DriverEntryPointsDTO firstDriverEntry) {
        this.firstDriverEntry = firstDriverEntry;
    }

    public void setSecondDriverEntry(DriverEntryPointsDTO secondDriverEntry) {
        this.secondDriverEntry = secondDriverEntry;
    }

    public void sumPoints() {
        this.points = this.firstDriverEntry.getPoints() + this.secondDriverEntry.getPoints();
    }

    public DriverEntryPointsDTO getDriverWithMorePoints() {
        if (this.firstDriverEntry.getPoints() > this.secondDriverEntry.getPoints())
            return this.firstDriverEntry;
        else
            return this.secondDriverEntry;
    }

    public DriverEntryPointsDTO getDriverWithLessPoints() {
        if (this.firstDriverEntry.getPoints() < this.secondDriverEntry.getPoints())
            return this.firstDriverEntry;
        else
            return this.secondDriverEntry;
    }

}
