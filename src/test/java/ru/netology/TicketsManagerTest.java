package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketsRepository;

import static org.junit.jupiter.api.Assertions.*;

public class TicketsManagerTest {
    TicketsRepository repo = new TicketsRepository();
    TicketsManager manager = new TicketsManager(repo);

    Ticket ticket1 = new Ticket(1, 2117, "LED", "DME", 90);
    Ticket ticket2 = new Ticket(2, 1895, "LED", "VKO", 60);
    Ticket ticket3 = new Ticket(3, 2110, "LED", "SVO", 90);
    Ticket ticket4 = new Ticket(4, 2120, "LED", "DME", 80);
    Ticket ticket5 = new Ticket(5, 3000, "SVO", "LED", 60);
    Ticket ticket6 = new Ticket(6, 2888, "DME", "LED", 77);
    Ticket ticket7 = new Ticket(7, 3333, "DME", "LED", 90);
    Ticket ticket8 = new Ticket(8, 1000, "DME", "LED", 90);

    @BeforeEach
    public void setup() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.save(ticket7);
        repo.save(ticket8);
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8};
        Ticket[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNecessaryTicketsTest() {
        Ticket[] expected = {ticket1, ticket4};
        Ticket[] actual = manager.findNecessaryTickets("LED", "DME");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindNecessaryTicketsTest2() {
        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.findNecessaryTickets("LED", "VKO");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNecessaryTicketsTest3() {
        Ticket[] expected = {ticket8, ticket6, ticket7};
        Ticket[] actual = manager.findNecessaryTickets("DME", "LED");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.removeById(4);
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket5, ticket6, ticket7, ticket8};
        Ticket[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


}