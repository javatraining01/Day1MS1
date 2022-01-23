package com.hashedin.day1.milestone1;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class milestone1 {

    public static void main(String[] args) {
        try {
            List<Show> shows = CsvHelper.parseCsv();
            if (shows.size() > 0) {
                try {

                    Scanner sc = new Scanner(System.in);

                    System.out.println("Please enter the number of Movies or TV Shows you want to search");
                    int n = sc.nextInt();

                    System.out.println("Please enter the start date in DD-MM-YYYY format");
                    String stDate = sc.next();

                    Date startDate = !stDate.equals("") ? new SimpleDateFormat("dd-MM-yyyy").parse(stDate) : null;
                    System.out.println("Please enter the end date in DD-MM-YYYY format");
                    String edDate = sc.next();
                    Date endDate = !stDate.equals("") ? new SimpleDateFormat("dd-MM-yyyy").parse(edDate) : null;

                    System.out.println("Please choose from below option to see the required results");
                    System.out.println("Enter 1 to Search Based on Type");
                    System.out.println("Enter 2 to Search Based on Genre");
                    System.out.println("Enter 3 to Search Based on Country");
                    String choice = String.valueOf(sc.nextInt());

                    switch (choice) {
                        case "1":
                            System.out.println("Please Enter type");
                            String type = sc.next();
                            ShowService.getFirstNTvShows(shows, n, type, startDate, endDate);
                            break;
                        case "2":
                            System.out.println("Please Enter Genre");
                            String genre = sc.next();
                            ShowService.getFirstNListedHorrorMovies(shows, n, genre, startDate, endDate);
                            break;
                        case "3":
                            System.out.println("Please Enter Country");
                            String country = sc.next();
                            ShowService.getFirstNIndianMovies(shows, n, country, startDate, endDate);
                            break;
                        default:
                            System.exit(0);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Empty File passed");
            }
        } catch (IOException | ParseException ioException) {
            System.out.println("File not present in the given location "+ioException);
        }

    }
}
