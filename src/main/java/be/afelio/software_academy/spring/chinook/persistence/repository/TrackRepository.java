package be.afelio.software_academy.spring.chinook.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.afelio.software_academy.spring.chinook.persistence.entities.TrackEntity;

public interface TrackRepository extends JpaRepository<TrackEntity, Integer> {

	List<TrackEntity> findAllTrackByAlbumTitle(String title);
}
