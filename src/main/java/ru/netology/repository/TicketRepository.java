package ru.netology.repository;

import ru.netology.domain.AboutTicket;

public class TicketRepository {
    private AboutTicket[] items = new AboutTicket[0];

    public void save(AboutTicket item) {
        int length = items.length + 1;
        AboutTicket[] tmp = new AboutTicket[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public AboutTicket[] findAll() {
        return items;
    }

    public AboutTicket findById(int id) {
        for (AboutTicket item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        AboutTicket[] tmp = new AboutTicket[length];
        int index = 0;
        for (AboutTicket item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }


}
