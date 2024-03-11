package de.herrmann.lowcode.irishmusic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity(name = "Script")
@Table(name = "Script")
public class Script {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENTITY_SEQ")
	@SequenceGenerator(name = "ENTITY_SEQ", sequenceName = "ENTITY_SEQ", allocationSize = 1)
	private Long id;
	
	private String name;
	private String description;
	private String code;
	private String workspace;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getWorkspace() {
		return workspace;
	}

	public void setWorkspace(String workspace) {
		this.workspace = workspace;
	}

	public Long getId() {
		return id;
	}
}
