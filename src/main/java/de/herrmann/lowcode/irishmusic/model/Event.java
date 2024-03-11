package de.herrmann.lowcode.irishmusic.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENTITY_SEQ")
	@SequenceGenerator(name = "ENTITY_SEQ", sequenceName = "ENTITY_SEQ", allocationSize = 1)
	private Long id;
	
	private Long artistId;
	private Long venueId;
	private Date date;
	
	public Long getArtistId() {
		return artistId;
	}
	
	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}
	
	public Long getVenueId() {
		return venueId;
	}
	
	public void setVenueId(Long venueId) {
		this.venueId = venueId;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Long getId() {
		return id;
	}
}
