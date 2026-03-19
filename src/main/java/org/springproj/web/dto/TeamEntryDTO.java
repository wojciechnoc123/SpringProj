package org.springproj.web.dto;


import lombok.Data;
import org.springproj.model.*;

@Data
public class TeamEntryDTO {

    private Team team;
    private Engine engine;
    private String chassisName;

}
//wywolanie z DriverEntry