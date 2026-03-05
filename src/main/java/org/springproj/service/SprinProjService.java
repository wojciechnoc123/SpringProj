package org.springproj.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springproj.repository.DriverDAO;
import org.springproj.repository.SeasonDAO;
import org.springproj.repository.TeamDAO;
import org.springproj.repository.sampleMem.MemDriverDao;
import org.springproj.repository.sampleMem.MemSeasonDao;
import org.springproj.repository.sampleMem.MemTeamDao;
import org.springproj.service.impl.SeasonServiceBean;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SprinProjService {
    public static void main(String[] args) {
        /*
        SeasonDAO seasons = new MemSeasonDao();
        DriverDAO drivers = new MemDriverDao();
        TeamDAO teams = new MemTeamDao();

        ApplicationContext context = new AnnotationConfigApplicationContext("org.springproj");
        SeasonServiceBean service = context.getBean(SeasonServiceBean.class);
        service.printAllSeasons();

        System.out.println();
        String foo = context.getBean(String.class);
        System.out.println(foo);
        */
    }
}