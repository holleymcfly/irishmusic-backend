package de.herrmann.lowcode.irishmusic.service;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.herrmann.lowcode.irishmusic.model.Artist;
import de.herrmann.lowcode.irishmusic.model.Event;
import de.herrmann.lowcode.irishmusic.model.Script;
import de.herrmann.lowcode.irishmusic.model.Venue;
import de.herrmann.lowcode.irishmusic.rules.BusinessRules;
import de.herrmann.lowcode.irishmusic.rules.JexlRules;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/irishMusic")
public class IrishMusicService {

	private final BusinessRules businessRules;
	private final JexlRules jexlRules;
	
	public IrishMusicService(BusinessRules businessRules, JexlRules jexlRules) {
		this.businessRules = businessRules;
		this.jexlRules = jexlRules;
	}
	
	@PostMapping("/artist")
	public Artist createArtist(@RequestBody Artist artist) {
		return businessRules.createArtist(artist);
	}
	
	@GetMapping("/artist")
	public List<Artist> getArtists() {
		return businessRules.getArtists();
	}
	
	@GetMapping("/artist/{artistId}")
	public Artist getArtist(@PathVariable Long artistId) {
		return businessRules.getArtistById(artistId);
	}
	
	@PutMapping("/artist")
	public Artist updateArtist(@RequestBody Artist artist) {
		return businessRules.updateArtist(artist);
	}
	
	@DeleteMapping("/artist")
	public void deleteArtist(@PathVariable Long artistId) {
		businessRules.deleteArtistById(artistId);
	}
	
	@GetMapping("/artist/{artistId}/event")
	public List<Event> getEventsForArtistId(@PathVariable Long artistId) {
		return businessRules.getEventsForArtistId(artistId);
	}
	
	@PostMapping("/venue")
	public Venue createVenue(@RequestBody Venue venue) {
		return businessRules.createVenue(venue);
	}
	
	@GetMapping("/venue")
	public List<Venue> getVenues() {
		return businessRules.getVenues();
	}
	
	@GetMapping("/venue/{venueId}")
	public Venue getVenue(@PathVariable Long venueId) {
		return businessRules.getVenueById(venueId);
	}
	
	@PutMapping("/venue")
	public Venue updateVenue(@RequestBody Venue venue) {
		return businessRules.updateVenue(venue);
	}
	
	@DeleteMapping("/venue")
	public void deleteVenue(@PathVariable Long venueId) {
		businessRules.deleteVenueById(venueId);
	}
	
	@PostMapping("/event")
	public Event createEvent(@RequestBody Event event) {
		return businessRules.createEvent(event);
	}
	
	@GetMapping("/event")
	public List<Event> getEvents() {
		return businessRules.getEvents();
	}
	
	@GetMapping("/event/{eventId}")
	public Event getEvent(@PathVariable Long eventId) {
		return businessRules.getEventById(eventId);
	}
	
	@PutMapping("/event")
	public Event updateEvent(@RequestBody Event event) {
		return businessRules.updateEvent(event);
	}
	
	@DeleteMapping("/event")
	public void deleteEvent(@PathVariable Long eventId) {
		businessRules.deleteEventById(eventId);
	}
	
	@PostMapping("/evaluateExpression")
	public Object evaluateExpression(@RequestBody String expression) {
		return jexlRules.evaluateExpression(expression);
	}
	
	@PostMapping("/script")
	public Script createScript(@RequestBody Script script) {
		return businessRules.createScript(script);
	}
	
	@GetMapping("/script")
	public List<Script> getScripts() {
		return businessRules.getScripts();
	}
	
	@GetMapping("/script/{scriptId}")
	public Script getScript(@PathVariable Long scriptId) {
		return businessRules.getScriptById(scriptId);
	}
	
	@PutMapping("/script")
	public Script updateScript(@RequestBody Script script) {
		return businessRules.updateScript(script);
	}
	
	@DeleteMapping("/script/{scriptId}")
	public void deleteScript(@PathVariable Long scriptId) {
		businessRules.deleteScriptById(scriptId);
	}

}
