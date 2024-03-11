package de.herrmann.lowcode.irishmusic.rules;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

import de.herrmann.lowcode.irishmusic.model.Event;

@Component
public class EventPlanningRules {

	private final BusinessRules businessRules;
	
	public EventPlanningRules(BusinessRules businessRules) {
		this.businessRules = businessRules;
	}
	
	/**
	 * Plan an event for the given artist at the given venue.
	 */
	public Event planEvent(Long artistId, Long venueId) {
		
		Event event = new Event();
		event.setArtistId(artistId);
		event.setVenueId(venueId);
		event.setDate(getEventDate());
		Event created = businessRules.createEvent(event);
		return created;
	}
	
	/**
	 * Return a random date within the next month.
	 */
    private Date getEventDate() {
    	
    	LocalDate today = LocalDate.now();
        LocalDate endOfNextMonth = today.plus(1, ChronoUnit.MONTHS).withDayOfMonth(1);
        LocalDate startOfNextMonth = endOfNextMonth.minusDays(1);

        long daysBetween = ChronoUnit.DAYS.between(today, startOfNextMonth);
        long randomDays = ThreadLocalRandom.current().nextLong(daysBetween);

        return Date.valueOf(startOfNextMonth.plus(randomDays, ChronoUnit.DAYS));
    }
}
