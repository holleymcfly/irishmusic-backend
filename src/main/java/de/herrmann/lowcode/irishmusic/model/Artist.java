package de.herrmann.lowcode.irishmusic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity(name = "Artist")
@Table(name = "Artist")
public class Artist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENTITY_SEQ")
	@SequenceGenerator(name = "ENTITY_SEQ", sequenceName = "ENTITY_SEQ", allocationSize = 1)
	private Long id;
	
	private String name;
	private byte[] photo;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public byte[] getPhoto() {
		return photo;
	}
	
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	public Long getId() {
		return id;
	}
}
