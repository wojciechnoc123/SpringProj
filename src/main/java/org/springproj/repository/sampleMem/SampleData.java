package org.springproj.repository.sampleMem;

import org.springproj.model.*;

import java.util.ArrayList;
import java.util.List;

public class SampleData {

    static List<Driver> sampleDrivers = new ArrayList<>();

    static List<Team> sampleTeams = new ArrayList<>();

    static List<Season> sampleSeasons = new ArrayList<>();

    static List<GrandPrix> sampleGrandPrixs = new ArrayList<>();

    static List<TeamEntry> sampleTeamEntries = new ArrayList<>();

     static List<DriverEntry> sampleDriversEntries = new ArrayList<>();

    static List<Engine> sampleEngines = new ArrayList<>();

    static List<EngineSupplier> sampleEngineSuppliers = new ArrayList<>();

    static List<Circuit> sampleCircuits = new ArrayList<>();



    static void bind(TeamEntry team, DriverEntry driver1, DriverEntry driver2) {
        team.setRaceDrivers(driver1, driver2);
        driver1.setTeam(team);
        driver2.setTeam(team);
    }

    static {
        //dostawcy silnikow
        EngineSupplier audiEngineSupplier = new EngineSupplier(1, "Audi", "Neuburg", "Germany");
        EngineSupplier mercedesEngineSupplier = new EngineSupplier(2, "Mercedes HPP", "Brixworth", "Germany");
        EngineSupplier ferrariEngineSupplier = new EngineSupplier(3, "Ferrari", "Maranello", "Italy");
        EngineSupplier redBullEngineSupplier = new EngineSupplier(4, "Red Bull Ford Powertrains", "Milton Keynes", "United Kingdom");

        sampleEngineSuppliers.add(audiEngineSupplier); sampleEngineSuppliers.add(mercedesEngineSupplier);
        sampleEngineSuppliers.add(ferrariEngineSupplier); sampleEngineSuppliers.add(redBullEngineSupplier);

        //silnik na 2026
        Engine audiEngine26 = new Engine(1,"Audi26",  audiEngineSupplier);
        Engine mercedesEngine26 = new Engine(2, "Mercedes26", mercedesEngineSupplier);
        Engine ferrariEngine26 = new Engine(3, "Ferrari26", ferrariEngineSupplier);
        Engine rbptEngine26 = new Engine(4, "RBPT26", redBullEngineSupplier);

        sampleEngines.add(audiEngine26); sampleEngines.add(mercedesEngine26);
        sampleEngines.add(ferrariEngine26); sampleEngines.add(rbptEngine26);

        //zespoly
        Team mclaren = new Team(1,"Mclaren", "Woking", "United Kingdom");
        Team ferrari = new Team(2,"Scuderia Ferrari", "Maranello", "Italy");
        Team mercedes = new Team(3,"Mercedes", "Brackley", "Germany");
        Team redbull = new Team (4,"Red Bull", "Milton Keynes", "United Kingdom");
        Team audi = new Team(5,"Audi", "Hinvil", "Switzerland");

        //zespoly na 2026
        TeamEntry mclaren26 = new TeamEntry(1, mclaren, mercedesEngine26, "MCL40");
        TeamEntry ferrari26 = new TeamEntry(2, ferrari, ferrariEngine26, "SF-26");
        TeamEntry mercedes26 = new TeamEntry(3, mercedes, mercedesEngine26, "W17");
        TeamEntry redbull26 = new TeamEntry(4, redbull, rbptEngine26, "RB22");
        TeamEntry audi26 = new TeamEntry(5, audi, audiEngine26, "R26");

        //uzupelnienie "pseudo bazy zespolow"
        sampleTeams.add(mclaren); sampleTeams.add(ferrari); sampleTeams.add(mercedes); sampleTeams.add(redbull); sampleTeams.add(audi);
        sampleTeamEntries.add(mclaren26); sampleTeamEntries.add(ferrari26); sampleTeamEntries.add(mercedes26);
        sampleTeamEntries.add(redbull26); sampleTeamEntries.add(audi26);

        //kierowcy
        Driver verstapen = new Driver(1,"Max", "Verstappen","Netherlands");
        Driver leclerc = new Driver(2,"Charles", "Leclerc", "Monaco");
        Driver hadjar = new Driver(3,"Isack", "Hadjar", "France");
        Driver bortoleto = new Driver(4,"Gabriel", "Bortoleto", "Brasil");
        Driver hulkenberg = new Driver(5,"Nico", "Hulkenberg", "Germany");
        Driver hamilton = new Driver(6,"Lewis", "Hamilton", "United Kingdom");
        Driver noriss = new Driver(7,"Lando", "Noriss","United Kingdom");
        Driver piastri = new Driver(8,"Oscar", "Piastri", "Australia");
        Driver russell = new Driver(9,"George", "Russell", "United Kingdom");
        Driver antonelli = new Driver(10,"Kimi", "Antonelli", "Italy");

        sampleDrivers.add(verstapen); sampleDrivers.add(leclerc); sampleDrivers.add(hadjar);
        sampleDrivers.add(hamilton); sampleDrivers.add(hulkenberg); sampleDrivers.add(bortoleto);
        sampleDrivers.add(noriss); sampleDrivers.add(piastri); sampleDrivers.add(russell); sampleDrivers.add(antonelli);


        //kierowcy na 2026
        DriverEntry verstapen26 = new DriverEntry(1, verstapen,3);
        DriverEntry leclerc26 = new DriverEntry(2, leclerc, 16);
        DriverEntry hadjar26 = new DriverEntry(3, hadjar, 6);
        DriverEntry bortoleto26 = new DriverEntry(4, bortoleto, 5);
        DriverEntry hulkenberg26 = new DriverEntry(5, hulkenberg, 27);
        DriverEntry hamilton26 = new DriverEntry(6, hamilton, 44);
        DriverEntry noriss26 = new DriverEntry(7, noriss, 1);
        DriverEntry piastri26 = new DriverEntry(8, piastri, 81);
        DriverEntry russell26 = new DriverEntry(9, russell, 63);
        DriverEntry antonelli26 = new DriverEntry(10, antonelli, 12);

        sampleDriversEntries.add(verstapen26); sampleDriversEntries.add(leclerc26);
        sampleDriversEntries.add(hadjar26);sampleDriversEntries.add(bortoleto26);
        sampleDriversEntries.add(hulkenberg26); sampleDriversEntries.add(hamilton26);
        sampleDriversEntries.add(noriss26); sampleDriversEntries.add(piastri26);
        sampleDriversEntries.add(russell26); sampleDriversEntries.add(antonelli26);



        //ustawienie gridu26
        bind(mclaren26, noriss26, piastri26); bind(ferrari26, leclerc26, hamilton26); bind(redbull26, verstapen26, hadjar26);
        bind(audi26, hulkenberg26, bortoleto26); bind(mercedes26, russell26, antonelli26);



        Season season26 = new Season(1,"2026");
        season26.setGrandPrixList(sampleGrandPrixs);
        season26.setDrivers(sampleDriversEntries);
        season26.setTeams(sampleTeamEntries);
        sampleSeasons.add(season26);

        Circuit silverstone = new Circuit(1, "Silverstone Circuit", "United Kingdom", "Silverstone");
        Circuit spielberg = new Circuit(2, "Red Bull Ring", "Austria", "Spielberg");

        sampleCircuits.add(silverstone); sampleCircuits.add(spielberg);

        GrandPrix gpBritain26 = new GrandPrix(1, "Austrian Grand Prix", spielberg, "Austria", "2026-07-06", season26);
        GrandPrix gpAustria26 = new GrandPrix(2, "British Grand Prix", silverstone, "United Kingdom", "2026-07-13", season26);

        sampleGrandPrixs.add(gpBritain26); sampleGrandPrixs.add(gpAustria26);

        gpAustria26.addResult(new Result(1, verstapen26, 5000.0, 73.0, gpAustria26));
        gpAustria26.addResult(new Result(2,russell26, 5005.0, 74.0, gpAustria26));
        gpAustria26.addResult(new Result(3, leclerc26, 5010.0, 75, gpAustria26));
        gpAustria26.addResult(new Result(4, hamilton26, 5011.0, 76, gpAustria26));
        gpAustria26.addResult(new Result(5, noriss26, 5012.0, 77, gpAustria26));
        gpAustria26.addResult(new Result(6, piastri26, 5013.0, 78, gpAustria26));
        gpAustria26.addResult(new Result(7, hadjar26, 5015.0, 75, gpAustria26));
        gpAustria26.addResult(new Result(8, antonelli26, 5020.0, 78, gpAustria26));
        gpAustria26.addResult(new Result(9, hulkenberg26, 5030.0, 79, gpAustria26));
        gpAustria26.addResult(new Result(10, bortoleto26, 5040.0, 80, gpAustria26));

        gpBritain26.addResult(new Result(1, verstapen26, 5000.0, 73.0, gpBritain26));
        gpBritain26.addResult(new Result(2,russell26, 5005.0, 74.0, gpBritain26));
        gpBritain26.addResult(new Result(3, leclerc26, 5010.0, 75, gpBritain26));
        gpBritain26.addResult(new Result(4, hamilton26, 5011.0, 76, gpBritain26));
        gpBritain26.addResult(new Result(5, noriss26, 5012.0, 77, gpBritain26));
        gpBritain26.addResult(new Result(6, piastri26, 5013.0, 78, gpBritain26));
        gpBritain26.addResult(new Result(7, hadjar26, 5015.0, 75, gpBritain26));
        gpBritain26.addResult(new Result(8, antonelli26, 5020.0, 78, gpBritain26));
        gpBritain26.addResult(new Result(9, hulkenberg26, 5030.0, 79, gpBritain26));
        gpBritain26.addResult(new Result(10, bortoleto26, 5040.0, 80, gpBritain26));



    }


}
