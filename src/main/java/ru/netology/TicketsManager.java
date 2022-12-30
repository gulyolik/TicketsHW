package ru.netology;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketsRepository;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TicketsManager {
    TicketsRepository repo = new TicketsRepository();

    public TicketsManager(TicketsRepository repo) {
        this.repo = repo;
    }

    public Ticket[] findNecessaryTickets(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (ticket.getDepartureAirport().equals(from)) {
                if (ticket.getArrivalAirport().equals(to)) {
                    Ticket[] tmp = new Ticket[result.length + 1];
                    for (int i = 0; i < result.length; i++) {
                        tmp[i] = result[i];
                    }
                    tmp[tmp.length - 1] = ticket;
                    result = tmp;
                }
            }
        }

        Arrays.sort(result);
        return result;
    }
}
