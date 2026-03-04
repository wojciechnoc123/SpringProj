package org.springproj;

import org.springproj.repository.DriverDAO;
import org.springproj.repository.RaceDAO;
import org.springproj.repository.SeasonDAO;
import org.springproj.repository.TeamDAO;
import org.springproj.repository.sampleMem.MemDriverDao;
import org.springproj.repository.sampleMem.MemSeasonDao;
import org.springproj.repository.sampleMem.MemTeamDao;
import org.springproj.service.impl.SeasonServiceBean;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String output = "eee";
        System.out.println("output " + output);

        SeasonDAO seasons = new MemSeasonDao();
        DriverDAO drivers = new MemDriverDao();
        TeamDAO teams = new MemTeamDao();

        SeasonServiceBean service = new SeasonServiceBean(seasons, teams, drivers);
        service.printAllSeasons();

    }
}