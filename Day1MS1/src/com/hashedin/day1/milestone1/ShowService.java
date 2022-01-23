package com.hashedin.day1.milestone1;


import java.util.*;

public class ShowService {


    public static void getFirstNTvShows(List<Show> show, int n, String type, Date startDate, Date endDate) {
        long executionStartTime = System.currentTimeMillis();
        show.stream().filter(m -> m.getDate_added() != null)
                .filter(m -> m.getType().equals(type)).limit(n)
                .filter(m -> m.getDate_added().after(startDate) && m.getDate_added().before(endDate))
                .forEach(System.out::println);
        long executionFinishTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (executionFinishTime - executionStartTime) + " ms");
    }


    public static void getFirstNListedHorrorMovies(List<Show> show, int n, String genre, Date startDate, Date endDate) {
        long executionStartTime = System.currentTimeMillis();
        show.stream().filter(m -> m.getDate_added() != null)
                .filter(m -> m.getListed_in().contains(genre)).limit(n)
                .filter(m -> m.getDate_added().after(startDate) && m.getDate_added().before(endDate))
                .forEach(System.out::println);
        long executionFinishTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (executionFinishTime - executionStartTime) + " ms");
    }

    public static void getFirstNIndianMovies(List<Show> show, int n, String country, Date startDate, Date endDate) {
        long executionStartTime = System.currentTimeMillis();
        show.stream().filter(m -> m.getDate_added() != null)
                .filter(m -> m.getType().equals("Movie") && m.getCountry().contains(country))
                .limit(n)
                .filter(m -> m.getDate_added().after(startDate) && m.getDate_added().before(endDate))
                .forEach(System.out::println);
        long executionFinishTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (executionFinishTime - executionStartTime) + " ms");
    }

    public static void display(List<List<String>> list) {
        for (List<String> rows : list) {

            System.out.println("Show Id='" + rows.get(0) + '\'' + ", Type='" + rows.get(1) + '\'' + ", Title='"
                    + rows.get(2) + '\'' + ", Director=" + rows.get(3) + ", " +
                    "Cast=" + rows.get(4) + ", Country=" + rows.get(5) + ", Date Added=" + rows.get(6) + ", Release Year='"
                    + rows.get(7) + '\'' + ", Rating='" + rows.get(8) + '\'' + ", Duration='" + rows.get(9) + '\'' + ", " +
                    "Listed In=" + rows.get(10) + ", Description='" + rows.get(11) + '\'');
        }
    }
}
