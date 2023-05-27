package com.driver.controllers;

import com.driver.model.Airport;
import com.driver.model.Flight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirportRepository {
    private Map<String,Airport> AirportsData=new HashMap<>();
    private Map<Integer, Flight> FlightData=new HashMap<>();
    private Map<Integer, Flight> PassengerData=new HashMap<>();
    public void addAirport(Airport airport) {
        AirportsData.put(airport.getAirportName(), airport);
    }

    public List<Airport> getLargestAirportName() {
        return new ArrayList<>(AirportsData.values());
    }

    public List<Flight> getShortestDurationOfPossibleBetweenTwoCities() {
        return new ArrayList<>(FlightData.values());
    }
}
