package by.tms.finalProject.service;

import by.tms.finalProject.entity.City;
import by.tms.finalProject.entity.Flight;
import by.tms.finalProject.entity.Passenger;
import by.tms.finalProject.entity.Reservation;
import by.tms.finalProject.repository.PassengerRepository;
import org.hibernate.JDBCException;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public boolean addPassenger(Passenger passenger) {
       try {
           passengerRepository.addPassenger(passenger);
           return true;
       }catch (ArithmeticException e){
           return false;
       }
    }

    @Override
    public Passenger findPassenger(Passenger passenger) {
       try {
           return passengerRepository.findPassenger(passenger);
       }catch (NoResultException e){
           return null;
       }
    }

    @Override
    @Transactional(readOnly = true)
    public boolean findPassengerByLogin(Passenger passenger) {
        try {
            passengerRepository.findPassengerByLogin(passenger);
            return true;
        }catch (NoResultException e){
            return false;
        }
    }

    @Override
    public void changePassenger(Passenger passenger) {
        passengerRepository.changePassenger(passenger);
    }

    @Override
    public List<Flight> getAllFlights() {
        return passengerRepository.getAllFlights();
    }

    @Override
    public Flight reservePlace(City cityFrom, City cityTo) {
        return passengerRepository.reservePlace(cityFrom, cityTo);
    }

    @Override
    public void reserve(Reservation reservation) {
        passengerRepository.reserve(reservation);
    }

}
