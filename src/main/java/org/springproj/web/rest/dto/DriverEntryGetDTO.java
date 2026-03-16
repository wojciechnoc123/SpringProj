package org.springproj.web.rest.dto;
import lombok.Data;
import org.springproj.model.*;

@Data
public class DriverEntryGetDTO {
    private Driver driver;
    private String teamName;
    private int number;
}
