package com.pluralsight.hibernatefundamentals;

import com.pluralsight.hibernatefundamentals.airport.Airport;
import com.pluralsight.hibernatefundamentals.airport.Passenger;
import com.pluralsight.hibernatefundamentals.airport.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m03.ex04");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Airport airport = new Airport(1, "Henri Coanda");

        Passenger john = new Passenger(1, "John Smith");
        john.setAirport(airport);
        john.setCity("Boston");
        john.setStreet("Flowers Street");
        john.setNumber("3");
        john.setZipCode("012345");
        john.setAreaCode("302");
        john.setPrefix("231");
        john.setLineNumber("951235");


        Passenger mike = new Passenger(2, "Michael Johnson");
        mike.setAirport(airport);
        airport.addPassenger(john);
        airport.addPassenger(mike);


        Ticket ticket1 = new Ticket();
        ticket1.setPassenger(john);
        ticket1.setSeries("AA");
        ticket1.setNumber("12345");
        ticket1.setOrigin("Brazil");
        ticket1.setDestination("London");


        john.addTicket(ticket1);

//        Ticket ticket3 = new Ticket(3, "CC0987");
//        ticket3.setPassenger(mike);


        em.persist(airport);
        em.persist(john);
        em.persist(mike);

        em.persist(ticket1);


        em.getTransaction().commit();
        emf.close();

    }
}
