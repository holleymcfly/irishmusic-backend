package de.herrmann.lowcode.irishmusic.rules;

import java.util.List;

import org.springframework.stereotype.Component;

import de.herrmann.lowcode.irishmusic.model.Artist;
import de.herrmann.lowcode.irishmusic.model.Event;
import de.herrmann.lowcode.irishmusic.model.Script;
import de.herrmann.lowcode.irishmusic.model.Venue;
import de.herrmann.lowcode.irishmusic.repository.ArtistRepository;
import de.herrmann.lowcode.irishmusic.repository.EventRepository;
import de.herrmann.lowcode.irishmusic.repository.ScriptRepository;
import de.herrmann.lowcode.irishmusic.repository.VenueRepository;

@Component
public class BusinessRules {

	private final ArtistRepository artistRepository;
	private final VenueRepository venueRepository;
	private final EventRepository eventRepository;
	private final ScriptRepository scriptRepository;
	
	public BusinessRules(ArtistRepository artistRepository, VenueRepository venueRepository, EventRepository eventRepository,
			ScriptRepository scriptRepository) {
		this.artistRepository = artistRepository;
		this.venueRepository = venueRepository;
		this.eventRepository = eventRepository;
		this.scriptRepository = scriptRepository;
	}
	
	public Artist createArtist(Artist artist) {
		return artistRepository.save(artist);
	}
	
	public List<Artist> getArtists() {
		List<Artist> result = artistRepository.findAll();
		return result;
	}
	
	public Artist getArtistById(Long id) {
		return artistRepository.getReferenceById(id);
	}
	
	public Artist updateArtist(Artist artist) {
		return artistRepository.save(artist);
	}
	
	public void deleteArtistById(Long id) {
		artistRepository.deleteById(id);
	}
	
	public Venue createVenue(Venue venue) {
		return venueRepository.save(venue);
	}
	
	public List<Venue> getVenues() {
		return venueRepository.findAll();
	}
	
	public Venue getVenueById(Long id) {
		return venueRepository.getReferenceById(id);
	}
	
	public Venue updateVenue(Venue artist) {
		return venueRepository.save(artist);
	}
	
	public void deleteVenueById(Long id) {
		venueRepository.deleteById(id);
	}
	
	public Event createEvent(Event event) {
		return eventRepository.save(event);
	}
	
	public List<Event> getEvents() {
		return eventRepository.findAll();
	}
	
	public Event getEventById(Long id) {
		return eventRepository.getReferenceById(id);
	}
	
	public Event updateEvent(Event event) {
		return eventRepository.save(event);
	}
	
	public void deleteEventById(Long id) {
		eventRepository.deleteById(id);
	}
	
	public List<Event> getEventsForArtistId(Long id) {
		return eventRepository.findByArtistId(id);
	}
	
	public Script createScript(Script script) {
		return scriptRepository.save(script);
	}
	
	public List<Script> getScripts() {
		List<Script> result = scriptRepository.findAll();
		return result;
	}
	
	public Script getScriptById(Long id) {
		return scriptRepository.getReferenceById(id);
	}
	
	public Script updateScript(Script script) {
		return scriptRepository.save(script);
	}
	
	public void deleteScriptById(Long id) {
		scriptRepository.deleteById(id);
	}
}

