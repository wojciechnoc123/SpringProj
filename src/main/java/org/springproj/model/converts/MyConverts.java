package org.springproj.model.converts;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class MyConverts {

    //accepts data as YYYY-MM-DD
    //fortunately formula 1 wasn't invented in Middle Ages so no need to bother with year <1000
    public static LocalDate convertFromDate(String date) {
        String regex = "[1-9][0-9][0-9][0-9]-((0[1-9])|(1[0-2]))-([1-9]|((0[1-9])|[1-2][0-9])|(3[0-1]))";
        LocalDate finalDate;
        if (date.matches(regex)) {
            String[] toLocalDate = date.split("-");
            finalDate = LocalDate.of(Integer.parseInt(toLocalDate[0]), Integer.parseInt(toLocalDate[1]), Integer.parseInt(toLocalDate[2]));
        }
        else
            finalDate = LocalDate.now();

        return finalDate;
    }
}
