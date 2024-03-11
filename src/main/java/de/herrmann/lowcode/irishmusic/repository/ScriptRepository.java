package de.herrmann.lowcode.irishmusic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.herrmann.lowcode.irishmusic.model.Script;

@Repository
public interface ScriptRepository extends JpaRepository<Script, Long>{
}
