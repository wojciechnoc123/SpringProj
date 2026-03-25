package org.springproj.service;

import org.springproj.model.DriverEntry;
import org.springproj.model.GrandPrix;
import org.springproj.web.dto.DriverEntryPointsDTO;

import java.util.List;

public interface StandingsService {

    int calculatePoints(DriverEntry driverEntry, List<GrandPrix> grandPrixes);

    public void calculatePointsAndSetPositions(DriverEntryPointsDTO driverEntryPointsDTO, List<GrandPrix> grandPrixes);

    public void setPositions(DriverEntryPointsDTO driverEntryPointsDTO, List<GrandPrix> grandPrixes);

}
