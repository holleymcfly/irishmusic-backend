package de.herrmann.lowcode.irishmusic.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.stereotype.Component;

import de.herrmann.lowcode.irishmusic.model.Artist;
import de.herrmann.lowcode.irishmusic.model.Venue;

@Component
public class ImportData {

	ArtistRepository artistRepository;
	VenueRepository venueRepository;
	EventRepository eventRepository;

	public ImportData(ArtistRepository artistRepository, VenueRepository venueRepository,
			EventRepository eventRepository) {
		this.artistRepository = artistRepository;
		this.venueRepository = venueRepository;
		this.eventRepository = eventRepository;
	}

	public void loadData() {

		if (notEmpty()) {
			return;
		}

		loadArtists();
		loadVenues();
	}
	
	private void loadVenues() {
		
		importVenue("Olympia Theatre", "Dublin", "Ireland");
		importVenue("Royal Hippodrome", "Eastbourne", "United Kingdom");
		importVenue("Wiener Metropol", "Wien", "Austra");
		importVenue("Bibelot", "Dordrecht", "Holland");
		importVenue("Matthäuskirche", "München", "Germany");
	}

	private void importVenue(String location, String city, String country) {
	
		Venue venue = new Venue();
		venue.setLocation(location);
		venue.setCity(city);
		venue.setCountry(country);
		venueRepository.save(venue);
	}
	
	private void loadArtists() {

		try {
			importArtist("The Dubliners", "TheDubliners.jpg");
			importArtist("The Pogues", "ThePogues.jpg");
			importArtist("The Chieftains", "TheChieftains.png");
			importArtist("The Clancy Brothers", "TheClancyBrothers.jpg");
			importArtist("The Popes", "ThePopes.gif");
		}
		catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	private void importArtist(String name, String fileName) throws IOException {
	
		Artist artist = new Artist();
		artist.setName(name);
		artist.setPhoto(toByteArray("D:/dev/sources/irishmusic/data/" + fileName));
		artistRepository.save(artist);
	}
	
	private boolean notEmpty() {
		return artistRepository.count() > 0;
	}

	private byte[] toByteArray(String fileName) throws IOException {

		File file = new File(fileName);
		return Files.readAllBytes(file.toPath());
	}
}
