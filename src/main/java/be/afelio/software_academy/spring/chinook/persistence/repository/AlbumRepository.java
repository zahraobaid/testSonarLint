package be.afelio.software_academy.spring.chinook.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import be.afelio.software_academy.spring.chinook.persistence.entities.AlbumEntity;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Integer> {

	List<AlbumEntity> findAll();

	List<AlbumEntity> findAllAlbumByArtistName(String artistName);
	List<AlbumEntity> findAllAlbumByTrackListGenreName(String genreName);

	AlbumEntity findOneById(int id);
	
}
