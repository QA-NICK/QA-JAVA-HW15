package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.TicketManager;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AboutTicketTest {
    private AboutTicket one = new AboutTicket(1, 123450, "DME", "SAR", 60);
    private AboutTicket two = new AboutTicket(2, 129900, "DME", "VOG", 70);
    private AboutTicket three = new AboutTicket(3, 69876, "DME", "SAR", 100);
    private AboutTicket four = new AboutTicket(4, 432300, "DME", "LED", 65);
    private AboutTicket five = new AboutTicket(5, 233646, "SAR", "DME", 75);
    TicketManager manager = new TicketManager(new TicketRepository());

    @BeforeEach
    public void setUp() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
    }


    @Test
    public void shouldSortByPrice() {
        AboutTicket[] expected = new AboutTicket[]{three, one, two, five, four};
        AboutTicket[] actual = new AboutTicket[]{one, two, three, four, five};

        Arrays.sort(actual);
        assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldFindAll() {
        AboutTicket[] expected = new AboutTicket[]{three, one};
        AboutTicket[] actual = manager.findAll("DME", "SAR");
        assertArrayEquals(expected, actual);

    }

}