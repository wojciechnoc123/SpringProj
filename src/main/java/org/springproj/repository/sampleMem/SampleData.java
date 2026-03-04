package org.springproj.repository.sampleMem;

import org.springproj.model.*;

import java.util.ArrayList;
import java.util.List;

public class SampleData {

    static List<Driver> sampleDrivers = new ArrayList<>();

    static List<Team> sampleTeams = new ArrayList<>();

    static List<Season> sampleSeasons = new ArrayList<>();

    static List<Race> sampleRaces = new ArrayList<>();

    static void bind(Team team, Driver driver1, Driver driver2) {
        team.setGridDrivers(driver1, driver2);
        team.addDriver(driver1);
        team.addDriver(driver2);
        driver1.setCurrentTeam(team);
        driver2.setCurrentTeam(team);
    }

    static {
        Team mclaren = new Team("Mclaren", "Woking", "United Kingdom");
        Team ferrari = new Team("Ferrari", "Maranello", "Italy");
        Team mercedes = new Team("Mercedes", "Brackley", "United Kingdom");
        Team redbull = new Team ("Red Bull", "Milton Keynes", "United Kingdom");
        Team audi = new Team("Audi", "Hinvil", "Switzerland");

        sampleTeams.add(mclaren); sampleTeams.add(ferrari); sampleTeams.add(mercedes); sampleTeams.add(redbull); sampleTeams.add(audi);

        Driver verstapen = new Driver("Max", "Verstappen", 3, 28);
        Driver leclerc = new Driver("Charles", "Leclerc", 27, 16);
        Driver hadjar = new Driver("Isack", "Hadjar", 6, 20);
        Driver hamilton = new Driver("Gabriel", "Bortoleto", 20, 5);
        Driver hulkenberg = new Driver("Nico", "Hulkenberg",38,27);
        Driver bortoleto = new Driver("Lewis", "Hamilton", 41, 44);
        Driver noriss = new Driver("Lando", "Noriss", 25, 1);
        Driver piastri = new Driver("Oscar", "Piastri", 24, 81);
        Driver russell = new Driver("George", "Russell", 27, 63);
        Driver antonelli = new Driver("Kimi", "Antonelli", 19, 12);

        bind(mclaren, noriss, piastri); bind(ferrari, leclerc, hamilton); bind(redbull, verstapen, hadjar);
        bind(audi, hulkenberg, bortoleto); bind(mercedes, russell, antonelli);

        sampleDrivers.add(verstapen); sampleDrivers.add(leclerc); sampleDrivers.add(hadjar);
        sampleDrivers.add(hamilton); sampleDrivers.add(hulkenberg); sampleDrivers.add(bortoleto);
        sampleDrivers.add(noriss); sampleDrivers.add(piastri); sampleDrivers.add(russell); sampleDrivers.add(antonelli);

        Season season25 = new Season("2025", sampleRaces);
        sampleSeasons.add(season25);

        Race gpBritain2025 = new Race("Silverstone", "Silverstone", "United Kingdom", "06-07", season25);
        Race gpAustria2025 = new Race("Red Bull Ring", "Spielberg", "Austria", "13-07", season25);

        sampleRaces.add(gpBritain2025); sampleRaces.add(gpAustria2025);

        gpAustria2025.addResult(new Result(1, verstapen, 5000.0, 73.0, gpAustria2025));
        gpAustria2025.addResult(new Result(2,russell, 5005.0, 74.0, gpAustria2025));
        gpAustria2025.addResult(new Result(3, leclerc, 5010.0, 75, gpAustria2025));
        gpAustria2025.addResult(new Result(4, hamilton, 5011.0, 76, gpAustria2025));
        gpAustria2025.addResult(new Result(5, noriss, 5012.0, 77, gpAustria2025));
        gpAustria2025.addResult(new Result(6, piastri, 5013.0, 78, gpAustria2025));
        gpAustria2025.addResult(new Result(7, hadjar, 5015.0, 75, gpAustria2025));
        gpAustria2025.addResult(new Result(8, antonelli, 5020.0, 78, gpAustria2025));
        gpAustria2025.addResult(new Result(9, hulkenberg, 5030.0, 79, gpAustria2025));
        gpAustria2025.addResult(new Result(10, bortoleto, 5040.0, 80, gpAustria2025));

        gpBritain2025.addResult(new Result(1, verstapen, 5000.0, 73.0, gpBritain2025));
        gpBritain2025.addResult(new Result(2,russell, 5005.0, 74.0, gpBritain2025));
        gpBritain2025.addResult(new Result(3, leclerc, 5010.0, 75, gpBritain2025));
        gpBritain2025.addResult(new Result(4, hamilton, 5011.0, 76, gpBritain2025));
        gpBritain2025.addResult(new Result(5, noriss, 5012.0, 77, gpBritain2025));
        gpBritain2025.addResult(new Result(6, piastri, 5013.0, 78, gpBritain2025));
        gpBritain2025.addResult(new Result(7, hadjar, 5015.0, 75, gpBritain2025));
        gpBritain2025.addResult(new Result(8, antonelli, 5020.0, 78, gpBritain2025));
        gpBritain2025.addResult(new Result(9, hulkenberg, 5030.0, 79, gpBritain2025));
        gpBritain2025.addResult(new Result(10, bortoleto, 5040.0, 80, gpBritain2025));



    }


}
