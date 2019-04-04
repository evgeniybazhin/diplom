package by.tms.finalProject.repository;

import by.tms.finalProject.entity.City;
import by.tms.finalProject.entity.Flight;
import by.tms.finalProject.entity.Passenger;
import by.tms.finalProject.entity.Reservation;

import java.util.List;

public interface PassengerRepository {
    void addPassenger(Passenger passenger);
    Passenger findPassenger(Passenger passenger);
    Passenger findPassengerByLogin(Passenger passenger);
    void changePassenger(Passenger passenger);
    List<Flight> getAllFlights();
    Flight reservePlace(City cityFrom, City cityTo);
    void reserve(Reservation reservation);

}
