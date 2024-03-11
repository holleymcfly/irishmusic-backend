package de.herrmann.lowcode.irishmusic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.herrmann.lowcode.irishmusic.model.Venue;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long>{

}
