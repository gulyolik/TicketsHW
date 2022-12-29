package ru.netology.domain;

public class Ticket implements Comparable <Ticket> {

    protected int id;
    protected int cost;
    protected String departureAirport;
    protected String arrivalAirport;
    protected int minutesPerFlight;

    public Ticket(int id, int cost, String departureAirport, String arrivalAirport, int minutesPerFlight) {
        this.id = id;
        this.cost = cost;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.minutesPerFlight = minutesPerFlight;
    }

    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public int getMinutesPerFlight() {
        return minutesPerFlight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public void setMinutesPerFlight(int minutesPerFlight) {
        this.minutesPerFlight = minutesPerFlight;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.cost < o.cost) {
            return -1;
        } else if (this.cost > o.cost) {
            return 1;
        } else {
            return 0;
        }
    }
}
