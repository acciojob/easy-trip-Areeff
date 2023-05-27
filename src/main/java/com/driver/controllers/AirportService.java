package com.driver.controllers;

import com.driver.model.Airport;
import com.driver.model.City;
import com.driver.model.Flight;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AirportService {
    AirportRepository airportRepository=new AirportRepository();

    public void addAirport(Airport airport) {
        airportRepository.addAirport(airport);
    }

    public String getLargestAirportName() {
        List<Airport> airports=airportRepository.getLargestAirportName();
        Collections.sort(airports, new Comparator<Airport>() {
            @Override
            public int compare(Airport o1, Airport o2) {
                //return o1.getNoOfTerminals()== o2.getNoOfTerminals()?o1.getAirportName().charAt(0)-o2.getAirportName().charAt(0): o1.getNoOfTerminals()-o2.getNoOfTerminals();
                    if (o1.getNoOfTerminals() == o2.getNoOfTerminals()) {
                        return o1.getAirportName().compareTo(o2.getAirportName());
                    }
                    else if(o1.getNoOfTerminals()-o2.getNoOfTerminals()>0){
                        return 1;
                    }
                    else{
                        return -1;
                    }
            }
        });
        return airports.get(0).getAirportName();
    }

    public double getShortestDurationOfPossibleBetweenTwoCities(City fromCity, City toCity) {
        List<Flight> flightList=airportRepository.getShortestDurationOfPossibleBetweenTwoCities();
        double shortDuration=Integer.MAX_VALUE;
        for(Flight flight:flightList){
            if(flight.getFromCity()==fromCity&&flight.getToCity()==toCity){
                if(shortDuration>flight.getDuration())  shortDuration=flight.getDuration();
            }
        }
       if(shortDuration==Integer.MAX_VALUE){
           return  0;
       }
       return shortDuration;
    }

    public int getNumberOfPeopleOn(Date date, String airportName) {
        List<Flight> flightList=airportRepository.getNumberOfPeopleOn();
        Airport airport=airportRepository.getAirport(airportName);
        City cityname=airport.getCity();
        int count=0;
        for(Flight flight:flightList){
            if(flight.getFlightDate().equals(date)){
                if(flight.getFromCity().equals(cityname)){
                    count+=flight.getMaxCapacity();
                }
                if(flight.getToCity().equals(cityname)){
                    count+=flight.getMaxCapacity();
                }
            }
        }
        return count;
    }

    public int calculateFare(Integer flightId) {
        List<Flight> flightList=airportRepository.getFilghts();
        return 0;
    }
}
