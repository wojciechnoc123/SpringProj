package org.springproj.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springproj.model.DriverEntry;
import org.springproj.model.GrandPrix;
import org.springproj.model.Result;
import org.springproj.service.StandingsService;
import org.springproj.web.dto.DriverEntryPointsDTO;

import java.util.List;

@Service
@Slf4j
public class StandingsServiceBean implements StandingsService {


    public int calculatePoints(DriverEntry driverEntry, List<GrandPrix> grandPrixes) {

        GrandPrix gp = null;
        List<Result> results = null;
        Result result = null;
        int sum = 0;
        //change to stream
        for (int gpIndex = 0; gpIndex < grandPrixes.size(); gpIndex++) {
            gp = grandPrixes.get(gpIndex);
            results = gp.getResults();
            for (int resultIndex = 0; resultIndex < results.size(); resultIndex++) {
                result = results.get(resultIndex);
                if (result.getDriver().equals(driverEntry))
                    sum += switch (result.getPosition()) {
                        case 1 -> 25;
                        case 2 -> 18;
                        case 3 -> 15;
                        case 4 -> 12;
                        case 5 -> 10;
                        case 6 -> 8;
                        case 7 -> 6;
                        case 8 -> 4;
                        case 9 -> 2;
                        case 10 -> 1;
                        default -> 0;
                    };
            }
        }
        return sum;
    }

    public void setPositions(DriverEntryPointsDTO driverEntryPointsDTO, List<GrandPrix> grandPrixes) {
        //only setting positions
    }

    public void calculatePointsAndSetPositions(DriverEntryPointsDTO driverEntryPointsDTO, List<GrandPrix> grandPrixes) {

        DriverEntry driverToFind = driverEntryPointsDTO.getDriverEntry();
        GrandPrix gp = null;
        List<Result> results = null;
        Result result = null;
        int sumOfPoints = 0;
        //change to stream
        for (int gpIndex = 0; gpIndex < grandPrixes.size(); gpIndex++) {
            gp = grandPrixes.get(gpIndex);
            results = gp.getResults();
            for (int resultIndex = 0; resultIndex < results.size(); resultIndex++) {
                result = results.get(resultIndex);
                if (result.getDriver().equals(driverToFind)) {
                    final int position = result.getPosition();
                    driverEntryPointsDTO.setPosition(position, gpIndex);
                    sumOfPoints += switch (position) {
                        case 1 -> 25;
                        case 2 -> 18;
                        case 3 -> 15;
                        case 4 -> 12;
                        case 5 -> 10;
                        case 6 -> 8;
                        case 7 -> 6;
                        case 8 -> 4;
                        case 9 -> 2;
                        case 10 -> 1;
                        default -> 0;
                    };
                }
            }
        }
        driverEntryPointsDTO.setPoints(sumOfPoints);
    }
}
