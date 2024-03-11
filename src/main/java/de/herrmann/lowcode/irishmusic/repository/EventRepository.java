package de.herrmann.lowcode.irishmusic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.herrmann.lowcode.irishmusic.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{

	public List<Event> findByArtistId(Long artistId);
}
