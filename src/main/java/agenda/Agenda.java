package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    private List<Event> lesEvents;
    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    public Agenda() {
        lesEvents = new ArrayList<>();
    }
    public void addEvent(Event e) {
        // TODO : implémenter cette méthode
        lesEvents.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return a list of events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        // TODO : implémenter cette méthode
        ArrayList<Event> eventsDay = new ArrayList<>();
        for (Event e : lesEvents) {
            if (e.isInDay(day)) {
                eventsDay.add(e);
            }
        }
        return eventsDay;
    }
}
