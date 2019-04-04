package by.tms.finalProject.service;

import by.tms.finalProject.entity.City;
import by.tms.finalProject.entity.Flight;
import by.tms.finalProject.entity.Passenger;
import by.tms.finalProject.entity.Reservation;

import java.util.List;

public interface PassengerService {
    boolean addPassenger(Passenger passenger);
    Passenger findPassenger(Passenger passenger);
    boolean findPassengerByLogin(Passenger passenger);
    void changePassenger(Passenger passenger);
    List<Flight> getAllFlights();
    Flight reservePlace(City cityFrom, City cityTo);
    void reserve(Reservation reservation);
}
