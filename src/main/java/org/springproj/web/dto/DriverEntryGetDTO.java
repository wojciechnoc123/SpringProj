package org.springproj.web.dto;
import lombok.Data;
import org.springproj.model.*;

@Data
public class DriverEntryGetDTO {
    private Driver driver;
    private String teamName;
    private int number;
}
