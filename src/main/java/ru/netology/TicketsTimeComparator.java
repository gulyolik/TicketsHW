package ru.netology;

import ru.netology.domain.Ticket;

import java.util.Comparator;

public class TicketsTimeComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        if (o1.getMinutesPerFlight() < o2.getMinutesPerFlight()) {
            return -1;
        } else if (o1.getMinutesPerFlight() > o2.getMinutesPerFlight()) {
            return 1;
        } else {
            return 0;
        }
    }
}
