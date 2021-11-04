package ru.netology.manager;

import ru.netology.domain.AboutTicket;
import ru.netology.repository.TicketRepository;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(AboutTicket ticket) {
        repository.save(ticket);
    }

    public AboutTicket[] findAll(String departureAirport, String arrivalAirport) {
        AboutTicket[] result = new AboutTicket[0];
        for (AboutTicket ticket : repository.findAll()) {
            if (ticket.matches(departureAirport, arrivalAirport)) {
                AboutTicket[] tmp = new AboutTicket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;


            }

        }
        return result;

    }
}
