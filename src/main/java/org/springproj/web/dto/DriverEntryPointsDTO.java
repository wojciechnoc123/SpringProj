package org.springproj.web.dto;

import lombok.Data;
import org.springproj.model.DriverEntry;
import org.springproj.model.GrandPrix;
import java.util.List;


public class DriverEntryPointsDTO {
    private DriverEntry driverEntry;
    private int points;
    private int[] positions;

    public DriverEntryPointsDTO(DriverEntry driverEntry, int points, int capacity) {
        this.driverEntry = driverEntry;
        this.points = points;
        this.positions = new int[capacity];
    }

    public DriverEntryPointsDTO(DriverEntry driverEntry, int capacity) {
        this.driverEntry = driverEntry;
        this.points = 0;
        this.positions = new int[capacity];
    }

    public DriverEntry getDriverEntry() {
        return driverEntry;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        if (points > 0) {
            this.points = points;
        }
    }

    public void setPosition(int position, int index) {
        if (index < this.positions.length && position > 0) {
            this.positions[index] = position;
        }
    }

    public int[] getPositions() {
        return this.positions;
    }



}
